// implement UntrustworthyMailWorker, Spy, Inspector, Thief, StolenPackageException, IllegalPackageException as public static classes here
public static class UntrustworthyMailWorker implements MailService {

    MailService[] mailServices;
    RealMailService realMailService;

    public UntrustworthyMailWorker(MailService... mailServices) {
        this.mailServices = mailServices;
        realMailService = new RealMailService();
    }

    @Override
    public Sendable processMail(Sendable mail) {
        for (int i = 0; i < mailServices.length; i++) {
            mail = mailServices[i].processMail(mail);
        }
        return getRealMailService().processMail(mail);
    }

    public MailService getRealMailService() {
        return realMailService;
    }
}

public static class Spy implements MailService {

    private Logger logger;

    public Spy(Logger logger) {
        this.logger = logger;
    }

    @Override
    public Sendable processMail(Sendable mail) {
        if (!(mail instanceof MailMessage)) {
            return mail;
        }
        MailMessage mailMessage = (MailMessage) mail;
        return mail;
    }
}
