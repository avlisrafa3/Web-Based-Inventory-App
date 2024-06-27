package com.example.demo.bootstrap;

import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.service.OutsourcedPartService;
import com.example.demo.service.OutsourcedPartServiceImpl;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 *
 *
 *
 *
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final PartRepository partRepository;
    private final ProductRepository productRepository;

    private final OutsourcedPartRepository outsourcedPartRepository;

    public BootStrapData(PartRepository partRepository, ProductRepository productRepository, OutsourcedPartRepository outsourcedPartRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        this.outsourcedPartRepository=outsourcedPartRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        if(partRepository.count() == 0) {
            OutsourcedPart o = new OutsourcedPart();
            o.setCompanyName("That Computer Store");
            o.setName("CPU");
            o.setInv(15);
            o.setMinInv(1);
            o.setMaxInv(100);
            o.setPrice(100.0);
            o.setId(100L);
            outsourcedPartRepository.save(o);
            OutsourcedPart thePart = null;
            List<OutsourcedPart> outsourcedParts = (List<OutsourcedPart>) outsourcedPartRepository.findAll();
            for (OutsourcedPart part : outsourcedParts) {
                if (part.getName().equals("CPU")) thePart = part;
            }
            System.out.println(thePart.getCompanyName());

            OutsourcedPart a = new OutsourcedPart();
            a.setCompanyName("This Computer Store");
            a.setName("GPU");
            a.setInv(15);
            a.setMinInv(1);
            a.setMaxInv(100);
            a.setPrice(300.0);
            a.setId(101L);
            outsourcedPartRepository.save(a);
            thePart = null;
            outsourcedParts = (List<OutsourcedPart>) outsourcedPartRepository.findAll();
            for (OutsourcedPart part : outsourcedParts) {
                if (part.getName().equals("GPU")) thePart = part;
            }
            System.out.println(thePart.getCompanyName());

            OutsourcedPart b = new OutsourcedPart();
            b.setCompanyName("Another Computer Store");
            b.setName("Motherboard");
            b.setInv(15);
            b.setMinInv(1);
            b.setMaxInv(100);
            b.setPrice(200.0);
            b.setId(102L);
            outsourcedPartRepository.save(b);
            thePart = null;
            outsourcedParts = (List<OutsourcedPart>) outsourcedPartRepository.findAll();
            for (OutsourcedPart part : outsourcedParts) {
                if (part.getName().equals("Motherboard")) thePart = part;
            }
            System.out.println(thePart.getCompanyName());

            OutsourcedPart c = new OutsourcedPart();
            c.setCompanyName("My Computer Store");
            c.setName("RAM");
            c.setInv(15);
            c.setMinInv(1);
            c.setMaxInv(100);
            c.setPrice(80.0);
            c.setId(103L);
            outsourcedPartRepository.save(c); // Changed from 'b' to 'c'
            thePart = null;
            outsourcedParts = (List<OutsourcedPart>) outsourcedPartRepository.findAll();
            for (OutsourcedPart part : outsourcedParts) {
                if (part.getName().equals("RAM")) thePart = part;
            }
            System.out.println(thePart.getCompanyName());

            OutsourcedPart h = new OutsourcedPart();
            h.setCompanyName("Western Governors University");
            h.setName("PSU");
            h.setInv(15);
            h.setMinInv(1);
            h.setMaxInv(100);
            h.setPrice(60.0);
            h.setId(104L);
            outsourcedPartRepository.save(h);
            thePart = null;
            outsourcedParts = (List<OutsourcedPart>) outsourcedPartRepository.findAll();
            for (OutsourcedPart part : outsourcedParts) {
                if (part.getName().equals("PSU")) thePart = part;
            }
            System.out.println(thePart.getCompanyName());
        }


           List<OutsourcedPart> outsourcedParts = (List<OutsourcedPart>) outsourcedPartRepository.findAll();
           for (OutsourcedPart part : outsourcedParts) {
               System.out.println(part.getName() + " " + part.getCompanyName());
           }



           if (productRepository.count() == 0) {
               Product desktop = new Product("Desktop", 400.0, 4);
               Product workstation = new Product("Workstation", 500.0, 5);
               Product gamingPc = new Product("Gaming PC", 850.0, 3);
               Product customBuildPc = new Product("Custom Build PC", 1000.0, 2);
               Product testBenchPc = new Product("Test Bench PC", 650.0, 4);
               productRepository.save(desktop);
               productRepository.save(workstation);
               productRepository.save(gamingPc);
               productRepository.save(customBuildPc);
               productRepository.save(testBenchPc);


               System.out.println("Started in Bootstrap");
               System.out.println("Number of Products" + productRepository.count());
               System.out.println(productRepository.findAll());
               System.out.println("Number of Parts" + partRepository.count());
               System.out.println(partRepository.findAll());
           }

    }
}


