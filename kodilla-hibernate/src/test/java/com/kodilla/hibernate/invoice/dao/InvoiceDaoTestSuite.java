package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class InvoiceDaoTestSuite {

    @Autowired
    InvoiceDao invoiceDao;

    @Test
    void testInvoiceDaoSave(){

        //Given
        Item item1 = new Item(new Product("Apple"), new BigDecimal(2), 57);
        Item item2 = new Item(new Product("Potato"), new BigDecimal(1), 32);
        Item item3 = new Item(new Product("Carrot"), new BigDecimal(4), 14);

        Invoice invoice = new Invoice("01/02/2019");
        item1.setInvoice(invoice);
        item2.setInvoice(invoice);
        item3.setInvoice(invoice);

        List<Item> items = new ArrayList<>();
        items.add(item1);
        items.add(item2);
        items.add(item3);

        invoice.setItemList(items);

        //When
        invoiceDao.save(invoice);
        int invoiceId = invoice.getId();
        int invoiceSize = invoice.getItemList().size();

        //Then
        assertNotEquals(0, invoiceId);
        assertEquals(3, invoiceSize);

        //CleanUp
        invoiceDao.deleteById(invoiceId);
    }
}
