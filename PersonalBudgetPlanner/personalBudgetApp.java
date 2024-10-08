
import java.util.Scanner;
public class personalBudgetApp{
	public static double calcInterestRate(double propertyPrice,double interestRate){
		return (interestRate/100)*propertyPrice;
	}
	public static double calcLoanRepayment(double propertyPrice,double totalPropertyDeposit,double totInterestRate,double numberOfMonths){
		
		return propertyPrice*(1 + (totInterestRate*numberOfMonths));
	}
	public static void main(String []args){
		String modelAndMake = "";
		double grossMonthlyIncome = 0,propertyPrice,interestRate,totInterestRate = 0,totalCarCost = 0,tot;
		double estimatedMonthlyTex = 0,rentalAmount,loanRepayment= 0,totalPropertyDeposit,insurancePremium,carPrice = 0;
		int numberOfMonths = 0;
		char rentalChoice = '0';
		char convetedRentalChoice = '0';
		char convertedCarChoice = '0';
		String[] estimatedMonthlyExp ={"Groceries","WaterAndLights","Travel cost","CellPhone and Telephone","Other  expenses"};
		double[] costOfExp = new double[5];
		Scanner sc = new Scanner(System.in);
		System.out.print("PLEASE ENTER YOUR GROSS MONTHLY INCOME : R ");
		grossMonthlyIncome = sc.nextDouble();
		System.out.print("PLEASE ENTER YOUR ESTIMATED MONTHLY TEX : R ");
		estimatedMonthlyTex = sc.nextDouble();
		for(int i = 0 ; i < costOfExp.length ; i++){
		System.out.print(estimatedMonthlyExp[i] + "--" + " R " );
		costOfExp[i] = sc.nextDouble();
		}
		System.out.println("PLEASE ENTER Y IF YOU ARE RENTING ACCOMODATION");
		System.out.println("PLEASE ENTER B IF YOU ARE BUYING A PROPERTY");
		rentalChoice = sc.next().charAt(0);
		 convetedRentalChoice = Character.toUpperCase(rentalChoice);
		if( convetedRentalChoice == 'Y' ){
			System.out.println("PLEASE ENTER THE AMOUNT FOR YOUR RENT : R");
			rentalAmount = sc.nextDouble();
		}	else if( convetedRentalChoice == 'B' ){
			System.out.print("Enter the purchase price of the property : R");
			propertyPrice = sc.nextDouble();
			System.out.print("Enter the total deposit :");
			totalPropertyDeposit = sc.nextDouble();
			System.out.print("Enter the enter the interest rate in percentage :");
			interestRate = sc.nextDouble();
			totInterestRate = calcInterestRate(propertyPrice,interestRate);
			System.out.print("Enter the number of months to repay :");
			numberOfMonths = sc.nextInt();
			loanRepayment = calcLoanRepayment(totInterestRate,propertyPrice,totalPropertyDeposit,numberOfMonths);
			if(loanRepayment > grossMonthlyIncome){
				System.out.println("the approval of the home loan is unlikely");
			}
		}else{
		    System.out.println("YOUR CHOICE IS INVALID");
		}System.out.println("Enter the letter C if you want to buy a car");
		 char carChoice = sc.next().charAt(0);
		  convertedCarChoice = Character.toUpperCase(carChoice);
		 if(convertedCarChoice == 'C'){
			 System.out.print("Enter the Model and Make of your car :");
			 modelAndMake =sc.next();
			 System.out.print("Enter the Purchase price for the car : R ");
			 propertyPrice = sc.nextDouble();
			 System.out.print("Enter the total deposit : R ");
			 totalPropertyDeposit = sc.nextDouble();
			 System.out.print("Enter the interest rate : R ");
			 interestRate = sc.nextDouble();
			 System.out.print("Enter the estimated insurance premium");
			 insurancePremium = sc.nextDouble();
			 carPrice = calcLoanRepayment(totInterestRate,propertyPrice,totalPropertyDeposit,numberOfMonths);
			 totalCarCost = carPrice + insurancePremium;
			 System.out.println("The total monthly cost for a car is : R " + totalCarCost);
		 }
		
		
	}
}