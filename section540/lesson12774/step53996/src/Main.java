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
