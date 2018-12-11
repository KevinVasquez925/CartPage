package bookstore;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.FontPosture;
import javafx.scene.shape.Rectangle;



public class Driver extends Application {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
		HBox searchAndCart = new HBox(10); 
		searchAndCart.setAlignment(Pos.CENTER);
		Button cart = new Button("Cart");
		TextField searchBar = new TextField("Title");
		Button findBtn = new Button("Search");
		HBox search = new HBox();
		
		//Creates the drop down menu for the ways to search for the books
		ChoiceBox<String> choiceBox = new ChoiceBox<>();
		choiceBox.getItems().addAll("Title", "Author", "ISBN", "Genre", "Release Date");
		choiceBox.setValue("Title");
		
		choiceBox.setOnAction(e -> getChoice(choiceBox, searchBar));
		findBtn.setOnAction(e -> searchChoice(searchBar));
		
		search.getChildren().addAll(searchBar, findBtn);
		searchAndCart.getChildren().addAll(choiceBox, search, cart);
		
		
		HBox booksDetails = new HBox(25);
		booksDetails.setAlignment(Pos.CENTER);
		VBox shoppingCart = new VBox(10);
		ChoiceBox<Integer> qtyBox = new ChoiceBox<>();
		qtyBox.getItems().addAll(1, 2, 3, 4, 5);
		qtyBox.setValue(1);
		Text qtyText = new Text("Qty");
		shoppingCart.setAlignment(Pos.TOP_CENTER);
		
		VBox qty = new VBox(3);
		qty.setAlignment(Pos.CENTER);
		qty.getChildren().addAll(qtyText, qtyBox);
		
		
		
		Text cartText = new Text("My Shopping Cart");
		cartText.setFont(Font.font("Courier", FontWeight.BOLD, 
			      FontPosture.REGULAR, 20));
		
		HBox bookPicAndTitle = new HBox(5);
		bookPicAndTitle.setAlignment(Pos.CENTER);
		Text titleAuthor = new Text("Title \nBy Author");
		Rectangle book1 = new Rectangle(75,100);
		bookPicAndTitle.getChildren().addAll(book1, titleAuthor);
		
		VBox price = new VBox(3);
		Text pText = new Text("Price");
		TextField pField = new TextField("$$$");
		pField.setDisable(true);
		price.setAlignment(Pos.CENTER);
		price.getChildren().addAll(pText, pField);
		
		booksDetails.getChildren().addAll(bookPicAndTitle, qty, price);
		shoppingCart.getChildren().addAll(cartText, booksDetails);
		
		//Making the Checkout area
		HBox tItems = new HBox(3);
		tItems.setAlignment(Pos.CENTER);
		Text totalItems = new Text("Total Items: ");
		TextField tbTotalItems = new TextField("Test");
		tbTotalItems.setDisable(true);
		tItems.getChildren().addAll(totalItems, tbTotalItems);
		
		HBox totalCost = new HBox(3);
		totalCost.setAlignment(Pos.CENTER);
		Text tCostText = new Text("Subtotal: ");
		TextField tbCost = new TextField("Test");
		tbCost.setDisable(true);
		totalCost.getChildren().addAll(tCostText, tbCost);
		
		Button buy = new Button("Buy Now");
		
		VBox orderItems = new VBox(20);
		orderItems.setAlignment(Pos.CENTER);
		orderItems.getChildren().addAll(tItems, totalCost, buy);
		
		BorderPane bPane = new BorderPane();
		bPane.setTop(searchAndCart);
		bPane.setCenter(shoppingCart);
		bPane.setBottom(orderItems);
		
		
		Scene scene = new Scene(bPane, 500, 600);
	    primaryStage.setTitle("CartScreen"); // Set the stage title
	    primaryStage.setScene(scene); // Place the scene in the stage
	    primaryStage.show(); // Display the stage
	}

	//Makes what you select int the choice box go in the seasrch bar
	private void getChoice(ChoiceBox<String> choiceBox, TextField SearchBar)
	{
		String choice = choiceBox.getValue();
		SearchBar.setText(choice);
	}
	
	//Searches the value in the text box
	//Right now it will just print what is in the bar, Change when we find out how to connect to the database
	private void searchChoice(TextField searchBar)
	{
		System.out.println(searchBar.getText());
	}
}
