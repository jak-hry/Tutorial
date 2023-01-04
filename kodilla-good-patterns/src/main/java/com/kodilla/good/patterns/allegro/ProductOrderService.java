package com.kodilla.good.patterns.allegro;

public class ProductOrderService {

    private final ProductOrderRepository productOrderRepository;
    private final MailService mailService;
    private final InformationService informationService;
    private final ProductCheck productCheck;

    public ProductOrderService(final ProductOrderRepository productOrderRepository, final MailService mailService, final InformationService informationService, final ProductCheck productCheck) {
        this.productOrderRepository = productOrderRepository;
        this.mailService = mailService;
        this.informationService = informationService;
        this.productCheck = productCheck;
    }

    public BuyDto process(User user, Product product, int quantity) {

        boolean check = productCheck.productCheck(user, product, quantity);
        boolean isOnStock = productOrderRepository.productOrder(user, product);

        if (check) {
            if (isOnStock) {
                mailService.sendMail(user, product);
                return new BuyDto(user, product, true);
            } else {
                informationService.inform(user, product);
                return new BuyDto(user, product, false);
            }
        } else {
            return new BuyDto(user, product, false);
        }
    }
}
