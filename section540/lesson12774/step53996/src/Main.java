// implement UntrustworthyMailWorker, Spy, Inspector, Thief, StolenPackageException, IllegalPackageException as public static classes here
public static class UntrustworthyMailWorker implements MailService {

    MailService[] mailServices;

    @Override
    public Sendable processMail(Sendable mail) {
        return mail;
    }
}
