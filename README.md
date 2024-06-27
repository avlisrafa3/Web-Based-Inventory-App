
C. mainscreen.html, line 14: changed title to "My Computer Store" and line 19: changed H1 header to "My Computer Store"
   from line 43 to line 86: Added Parts to the table (Cooler; Computer Case; RAM; CPU, Power Supply)
   from line 115 to line 158: Added Products to the table(Gaming PC, Workstation, Desktop, Test Bench, Custom Build PC)

Note: Do not remove any elements that were included in the screen. You may add any additional elements you would like or any images, colors, and styles, although it is not required.


D.  Added an “About” page to the application: about.html(line 1 to 18) Contains a description of the company to web viewers and a button to redirect to the mainscreen.html
    Added button to mainscreen.html (line 20 to access "About Us" page)
   Added java class to src/main/java/com/example/demo/controllers/AboutPageController.java to make a controller and mapping for the navigation

E. Added sample inventory parts and products on src/main/java/com/example/demo/bootstrap/BootStrapData.java from line 42 to line 132.
   Using if statements to verify if the inventory of parts and products are 0 before adding them and prevent re-add once app is re-launched. 



F.  Added "Buy Now" button on mainscreen.html to the product list. Line 83.
    Created buyNowSuccess.html and buyNowFailure.html pages to src/main/resources/templates.
    Created BuyNowController.java on src/main/java/com/example/demo/controllers to handle errors.
    Added to MainScreenController.java, the mapping for the "Buy Now" button. Line 54 to line 64.
    Added the logic to decrement the products when the "Buy Now" button is used on src/main/java/com/example/demo/service/ProductServiceImpl.java. Line 68 to 84.


G.  Added additional fields to the part entity for Max and Min Inventory on mainscreen.html line 38 and line 39.
    Modified sample inventory to include Min and Max fields in BootStrapData.java.
    Added to InhousePartForm.html additional text input for inventory for min and max value(line 23 & line 25).
    Added to OutsourcedPartForm.html additional text input for inventory for min and max value(line 25 & line 27).
    Renamed the file the persistent storage is saved to, to dataSource at src/main/resources/application.properties.
    Modified the code to enforce that inventory is between min and max value:
        src/main/java/com/example/demo/domain/Part.java: Added @Min and @Max, setter & getter, and validation to ensure values are between min and max.(line 113 to line 139).
        src/main/java/com/example/demo/controllers/AddInhousePartController.java edited code from line 36 to line 57 to ensure validation of Inventory in between ranges.
        src/main/java/com/example/demo/controllers/AddOutsourcedPartController.java edited code from line 37 to line 56 to ensure validation of Inventory in between ranges.


H.  src/main/java/com/example/demo/validators/ValidEnufParts.java: Line 20: Message to tell inventory is low when adding to product.
    src/main/java/com/example/demo/validators/EnufPartsValidator.java: Line 36: if statement that returns false to check if any of the parts for the product would fall below their minimum if the product was made.
    Re-wrote message errors and Min and Max values to 1 - 100.

I.  src/test/java/com/example/demo/domain/PartTest.java: Line 159 to Line 171: Unit tests for the maximum and minimum fields.


J. Removed src/main/java/com/example/demo/validators/DeletePartValidator.java file due to unused validator. 

Extra: Uncommented code in productForm.html line 74 to have Link to main screen.
        Added CSS to src/main/resources/static/css/demo.css
        Created new css file in src/main/resources/static/css/ called style.css to style forms.
        Updated about.html, buyNowSucess.html, buyNowFailure.html, InhousePartForm.html, mainscreen.html, OutsourcedPartForm.html & productForm.html to have <link> to css file.

Part H.
src/main/java/com/example/demo/validators/EnufPartsValidator.java: Line 30 to Line 48(Fixed Logic to Validation.