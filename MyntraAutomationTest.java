package Myntra_automate;
		import org.openqa.selenium.By;
		import org.openqa.selenium.WebDriver;
		import org.openqa.selenium.WebElement;
		import org.openqa.selenium.chrome.ChromeDriver;

		public class MyntraAutomationTest {

		    public static void main(String[] args) {
		        // Set the path to your ChromeDriver executable
		        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

		        // Create a new instance of the Chrome driver
		        WebDriver driver = new ChromeDriver();

		        try {
		            // Automate User Registration Process
		            registerUser(driver);

		            // Automate Login Process
		            loginUser(driver);

		            // Automate Adding a Product to the Shopping Cart
		            addProductToCart(driver);

		        } catch (Exception e) {
		            e.printStackTrace();
		        } finally {
		            // Close the browser
		            driver.quit();
		        }
		    }

		    private static void registerUser(WebDriver driver) {
		        // Navigate to the registration page
		        driver.get("https://www.myntra.com/register");

		        // Fill out the registration form
		        driver.findElement(By.id("userName")).sendKeys("unique_username");
		        driver.findElement(By.id("userEmail")).sendKeys("unique_email@example.com");
		        driver.findElement(By.id("userPassword")).sendKeys("password123");

		        // Submit the form
		        driver.findElement(By.id("register-button")).click();

		        // Verify successful registration (you might need to adjust this based on the actual behavior)
		        WebElement successMessage = driver.findElement(By.xpath("//div[@class='success-message']"));
		        if (successMessage.isDisplayed()) {
		            System.out.println("Registration successful!");
		        } else {
		            System.out.println("Registration failed!");
		        }
		    }

		    private static void loginUser(WebDriver driver) {
		        // Navigate to the login page
		        driver.get("https://www.myntra.com/login");

		        // Enter credentials
		        driver.findElement(By.id("userEmail")).sendKeys("unique_email@example.com");
		        driver.findElement(By.id("userPassword")).sendKeys("password123");

		        // Submit the form
		        driver.findElement(By.id("login-button")).click();

		        // Verify successful login (you might need to adjust this based on the actual behavior)
		        WebElement loggedInIndicator = driver.findElement(By.xpath("//div[@class='logged-in-indicator']"));
		        if (loggedInIndicator.isDisplayed()) {
		            System.out.println("Login successful!");
		        } else {
		            System.out.println("Login failed!");
		        }
		    }

		    private static void addProductToCart(WebDriver driver) {
		        // Navigate through product categories (you might need to adjust this based on the actual behavior)

		        // Select a specific product
		        driver.findElement(By.xpath("//a[contains(text(),'Women')]")).click();
		        driver.findElement(By.xpath("//a[contains(text(),'Dresses')]")).click();
		        driver.findElement(By.xpath("//a[contains(text(),'Product Name')]")).click();

		        // Add the product to the shopping cart
		        driver.findElement(By.xpath("//button[contains(text(),'Add to Cart')]")).click();

		        // Validate that the product is added to the cart
		        driver.get("https://www.myntra.com/checkout/cart");
		        WebElement cartProduct = driver.findElement(By.xpath("//div[@class='cart-product']"));

		        if (cartProduct.isDisplayed()) {
		            System.out.println("Product added to the cart successfully!");
		        } else {
		            System.out.println("Failed to add the product to the cart!");
		        }
		    }
		


	}


