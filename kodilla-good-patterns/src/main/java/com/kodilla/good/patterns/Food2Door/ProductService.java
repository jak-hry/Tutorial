package com.kodilla.good.patterns.Food2Door;

public class ProductService {

    private final TelephoneService telephoneService;
    private final Information information;
    private final ProductCheck productCheck;
    private final OrderRepository orderRepository;

    public ProductService(final TelephoneService telephoneService, final Information information,
                          final ProductCheck productCheck, final OrderRepository orderRepository) {
        this.telephoneService = telephoneService;
        this.information = information;
        this.productCheck = productCheck;
        this.orderRepository = orderRepository;
    }

    public OrderDto process(Customer customer, Producer producer, Product product) {

        boolean check = productCheck.productCheck(customer, product);

        if (check) {
            boolean isInStock = orderRepository.productOrder(customer, product);
            if (isInStock) {
                telephoneService.sendSms(customer);
                return new OrderDto(customer, product, true);
            } else {
                information.inform(customer, producer);
                return new OrderDto(customer, product, false);
            }
        } else {
            return new OrderDto(customer, product, false);
        }
    }

    public void process(OrderRequest orderRequest) {

        orderRequest.process();
    }
}
