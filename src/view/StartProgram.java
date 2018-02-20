package view;

import java.util.List;
import java.util.Scanner;

import controller.GalleryPieceHelper;
import model.GalleryPiece;

public class StartProgram {
	static Scanner scan = new Scanner(System.in);
	static GalleryPieceHelper gph = new GalleryPieceHelper();
	
	private static void addGalleryPiece() {
		System.out.println("Enter the title of the art work: ");
		String title = scan.nextLine();
		System.out.println("Enter the artist's name: ");
		String artistName = scan.nextLine();
		System.out.println("Would you like to enter additional details on the artwork? y/n");
		String additionalDetails = scan.nextLine();
		if(additionalDetails.equalsIgnoreCase("y")) {
			System.out.println("Enter the media of the artwork: ");
			String media = scan.nextLine();
			System.out.println("Enter the year the artwork was created: ");
			String year = scan.nextLine();
			System.out.println("Enter the value of the artwork: ");
			double value = scan.nextDouble();
			scan.nextLine();
			GalleryPiece toAdd = new GalleryPiece(title, artistName, media, year, value);
			gph.insertArt(toAdd);
		}
		else {
			GalleryPiece toAdd = new GalleryPiece(title, artistName);
			gph.insertArt(toAdd);
		}

	}
	
	private static void deleteGalleryPiece() {
		System.out.println("Enter the title of the artwork to delete: ");
		String title = scan.nextLine();
		System.out.println("Enter the name of the artist who created that artwork: ");
		String artistName = scan.nextLine();
		GalleryPiece toDelete = new GalleryPiece(title, artistName);
		gph.deleteItem(toDelete);
	}
	
	private static void viewGallery() {
		List<GalleryPiece> allArtwork = gph.showAllArtwork();
		for(GalleryPiece gp : allArtwork) {
			if(gp.getMedia()==null || gp.getYear() == null || gp.getValue() == 0) {
				System.out.println(gp.returnTitleArtist());
			}
			else {
				System.out.println(gp.returnAllArtDetails());
			}
		}
	}
	
	public static void main(String[] args) {
		runMenu();
	}

	private static void runMenu() {
		// TODO Auto-generated method stub
		boolean continueMenu = true;
		System.out.println("--- Welcome to the gallery! ---");
		while (continueMenu) {
			System.out.println("*  Select an itme:");
			System.out.println("*  1 -- View the list");
			System.out.println("*  2 -- Add an item");
			System.out.println("*  3 -- Delete an item");
			System.out.println("*  4 -- Exit the program");
			System.out.println("*  Your Selection");
			int selection = scan.nextInt();
			scan.nextLine();
			
			if(selection==1) {
				viewGallery();
			}
			else if (selection == 2) {
				addGalleryPiece();
			}
			else if (selection == 3) {
				deleteGalleryPiece();
			}
			else {
				System.out.println("  Goodbye!  ");
				continueMenu = false;
			}
		}
	}
	
}
