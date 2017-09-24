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
        if (mailMessage.getFrom().equals(AUSTIN_POWERS)
                || mailMessage.getTo().equals(AUSTIN_POWERS)) {
            logger.log(Level.WARNING,
                    "Detected target mail correspondence: from {0} to {1} \"{2}\"",
                    new Object[]{mailMessage.getFrom(), mailMessage.getTo(), mailMessage.getMessage()});
        } else {
            logger.log(Level.INFO,
                    "Usual correspondence: from {0} to {1}",
                    new Object[]{mailMessage.getFrom(), mailMessage.getTo()});
        }
        return mail;
    }
}

public static class Thief implements MailService {

    private int minPriceToSteal;
    private int stolenValue;

    public Thief(int minPriceToSteal) {
        this.minPriceToSteal = minPriceToSteal;
    }

    @Override
    public Sendable processMail(Sendable mail) {
        if (!(mail instanceof MailPackage)) {
            return mail;
        }
        MailPackage mailPackage = (MailPackage) mail;
        return mail;
    }

    public int getStolenValue() {
        return stolenValue;
    }
}
