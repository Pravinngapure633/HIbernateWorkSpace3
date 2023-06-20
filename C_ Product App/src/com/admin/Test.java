package com.admin;

import java.util.Scanner;

import com.serviceimpl.ProductService;

public class Test {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		ProductService service = new ProductService();
		
		boolean flag=true;
		while (flag) {
			System.out.println("Enter 1 For Add Product");
			System.out.println("Enter 2 For Get Product");
			System.out.println("Enter 3 For Delete Product");
			System.out.println("Enter 4 For Update Product");
			System.out.println("Enter 5 For Exit App");

			switch (sc.nextInt()) {
			case 1:
				service.addProduct();
				break;
			case 2:
				service.getProduct();
				break;
			case 3:
				service.deleteProduct();
				break;
			case 4:
				service.updateProduct();
				break;
			case 5:
				System.out.println("****Thank You*****");
				System.exit(0);
				break;
			default:
				System.out.println("!!!!!! Wrong Input provided  !!!!!!");
				break;
			}
			
		}
	}
}
