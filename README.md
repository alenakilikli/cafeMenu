# cafeMenu
Create an engine for a café menu
**The system should support:**

- Add new product
- List all products names
- List product info
- Delete product
- *Update product info

**Add new product**

**Product has fields:**

- name
- price
- description
- category
- isAvailable

Product list is stored in file `"/cafe/products.cafe"`
Each product should be stored in folder `"/cafe/products/{category}/{product_name}.cafe"`

**Product creation process:**

1. Product object gets created/read from console
2. Create a product file under `"/products/{category}/{product_name}.cafe"`
**File format**
*name^price^description^category^isAvailable*
3. Add product to `"/cafe/products.cafe"`
*product_name^/path/to/product^is_available*

**Validations:**

- Products should be unique per category, there cannot be "Coffee" added twice.
So, after #1, it is necessary to unsure there isn't sush product

**List all products names**

Find a file `"/cafe/products.cafe"` and list all products names
**The system should support three ways of listing:**

- with "`isAvailable`" flag (only available)
- list products at all

**List product info**

**The system should support 2 ways of searching:**

- by the full path (see add new product #3)
- by a lookup: category + product name

If there is no such product - should throw FileNotFoundException

**Delete product**

**The system should support 2 ways of deleting:**

- by the full path (see add new product #3)
- by a lookup: category + product name

**Note**: when the product is deleted from `"/products/{category}"` folder, should be also deleted from `"/products/products.cafe"` file

***Update product info (optional)**

- Read the product data from `"/products/{category}/{product_name}.cafe"`
- Update the existing product
- If product name is changed:
    - verify such product does not exist
    - change product name and the path in `"products.cafe"`
    - rename `“/{category}/{product_name}.cafe”`

**Implementation notes:**

- The engine should be an interface and the Impl
- At any time, any class cannot exceed 100 lines of code, including all spaces, imports, etc
- The solution may contain as many classes and packages as needed.
- It is **not** expected to implement a console menu.
- All connections (read and write) should be closed, using try-with-resources
- You can pick up classes:
    - InputStream/OutputStream
    - Reader/Writer
    - Any related adapters and decorators you need
- You cannot use classes, that bring the entire content in a single line or stream, such as `Files.readAllLines`, or similar
- The solution should be uploaded to **GitHub**
