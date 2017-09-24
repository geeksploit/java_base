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
        return mail;
    }
}
