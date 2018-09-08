import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.hypergraphdb.HGEnvironment;
import org.hypergraphdb.HGHandle;
import org.hypergraphdb.HGLink;
import org.hypergraphdb.HGQuery.hg;
import org.hypergraphdb.HGSearchResult;
import org.hypergraphdb.HGValueLink;
import org.hypergraphdb.HyperGraph;
import org.hypergraphdb.IncidenceSet;
import org.hypergraphdb.peer.StorageService.Operation;
import org.hypergraphdb.query.And;
import org.hypergraphdb.query.AtomPartCondition;
import org.hypergraphdb.query.AtomTypeCondition;
import org.hypergraphdb.query.ComparisonOperator;
import org.hypergraphdb.query.HGQueryCondition;
import org.hypergraphdb.query.Not;


public class RessellersChain {

	public static void main(String[] args) {
		String location = "D:/Documents/Polimi/Database Systems 2/Project/Project";
		try
		{
			//Creating the Graph DB
			HyperGraph resellerChainGraph = HGEnvironment.get(location);	
			
			//Graph DB Nodes (Atoms)
			Supplier Supplier1 = new Supplier("Supplier 1", "Milano");	
			Supplier Supplier2 = new Supplier("Supplier 2", "Roma");
			
			MarketingDivision MarketingDivision1 = new MarketingDivision("Marketing Division 1", "Head of Division");
			
			Headquarter HeadquarterMilano = new Headquarter("Milano Headquarter", "Milano");
			Headquarter HeadquarterRoma = new Headquarter("Roma Headquarter", "Roma");
			Headquarter HeadquarterGenova = new Headquarter("Genova Headquarter", "Genova");
			Headquarter HeadquarterVerona = new Headquarter("Verona Headquarter", "Verona");
			
			Warehouse WarehouseMilano1 = new Warehouse("Milano Warehouse 1", "Milano", 1200);
			Warehouse WarehouseMilano2 = new Warehouse("Milano Warehouse 2", "Milano", 500);
			Warehouse WarehouseRoma = new Warehouse("Roma Warehouse", "Roma", 1600);
			Warehouse WarehouseGenova = new Warehouse("Genova Warehouse", "Genova", 1000);
			Warehouse WarehouseVerona = new Warehouse("Verona Warehouse", "Verona", 1100);
			
			Reseller ResellerMilano1 = new Reseller("Milano Reseller 1", "Milano");
			Reseller ResellerMilano2 = new Reseller("Milano Reseller 2", "Milano");
			Reseller ResellerMilano3 = new Reseller("Milano Reseller 3", "Milano");
			Reseller ResellerRoma1 = new Reseller("Roma Reseller 1", "Roma");
			Reseller ResellerRoma2 = new Reseller("Roma Reseller 2", "Roma");
			Reseller ResellerRoma3 = new Reseller("Roma Reseller 3", "Roma");
			Reseller ResellerRoma4 = new Reseller("Roma Reseller 4", "Roma");
			Reseller ResellerRoma5 = new Reseller("Roma Reseller 5", "Roma");
			Reseller ResellerGenova = new Reseller("Genova Reseller", "Genova");
			Reseller ResellerVerona= new Reseller("Verona Reseller", "Verona");
			
			LoyaltyProgram LoyaltyProgram1 = new LoyaltyProgram("card", "More than 100 euros per week");
			LoyaltyProgram LoyaltyProgram2 = new LoyaltyProgram("card", "More than 200 euros monthly");
			
			Customer Customer1 = new Customer("Customer 1", "Genova", 24, "Group 1");
			Customer Customer2 = new Customer("Customer 2", "Milano", 30, "Group 1");
			Customer Customer3 = new Customer("Customer 3", "Milano", 33, "Group 2");
			Customer Customer4 = new Customer("Customer 4", "Roma", 18, "Group 2");
			Customer Customer5 = new Customer("Customer 5", "Verona", 40, "Group 2");
			Customer Customer6 = new Customer("Customer 6", "Roma", 19, "Group 3");
			Customer Customer7 = new Customer("Customer 7", "Milano", 22, "Group 3");
			Customer Customer8 = new Customer("Customer 8", "Genova", 17, "Group 3");
			Customer Customer9 = new Customer("Customer 9", "Roma", 62, "Group 3");
			Customer Customer10 = new Customer("Customer 10", "Roma", 38, "Group 1");
			Customer Customer11 = new Customer("Customer 11", "Verona", 26, "Group 1");
			Customer Customer12 = new Customer("Customer 12", "Milano", 38, "Group 1");
			Customer Customer13 = new Customer("Customer 13", "Roma", 27, "Group 1");
			Customer Customer14 = new Customer("Customer 14", "Milano", 15, "Group 2");
			
			AmountPerDay AmountPerDay1 = new AmountPerDay(50.0, "22/01/2010", "Product Group 1", 22, 1);
			AmountPerDay AmountPerDay2 = new AmountPerDay(150.0, "12/01/2010", "Product Group 2", 12, 1);
			AmountPerDay AmountPerDay3 = new AmountPerDay(200.0, "02/02/2010", "Product Group 3", 2, 2);
			AmountPerDay AmountPerDay4 = new AmountPerDay(110.0, "22/03/2010", "Product Group 1", 22, 3);
			AmountPerDay AmountPerDay5 = new AmountPerDay(60.0, "04/04/2010", "Product Group 1", 4, 4);
			AmountPerDay AmountPerDay6 = new AmountPerDay(70.0, "06/01/2010", "Product Group 2", 6, 1);
			AmountPerDay AmountPerDay7 = new AmountPerDay(300.0, "12/12/2010", "Product Group 2", 12, 12);
			AmountPerDay AmountPerDay8 = new AmountPerDay(10.0, "20/01/2010", "Product Group 3", 20, 1);
			AmountPerDay AmountPerDay9 = new AmountPerDay(230.0, "21/01/2010", "Product Group 1", 21, 1 );
			AmountPerDay AmountPerDay10 = new AmountPerDay(80.0, "15/01/2010", "Product Group 3", 15, 1);
			AmountPerDay AmountPerDay11 = new AmountPerDay(300.0, "22/05/2010", "Product Group 1", 22, 5);
			AmountPerDay AmountPerDay12 = new AmountPerDay(80.0, "12/06/2010", "Product Group 1", 12, 6);
			AmountPerDay AmountPerDay13 = new AmountPerDay(140.0, "09/11/2010", "Product Group 2", 9, 11);
			AmountPerDay AmountPerDay14 = new AmountPerDay(230.0, "14/10/2010", "Product Group 1", 14, 10);
			AmountPerDay AmountPerDay15 = new AmountPerDay(90.0, "15/07/2010", "Product Group 2", 15, 7);
			AmountPerDay AmountPerDay16 = new AmountPerDay(140.0, "24/08/2010", "Product Group 3", 24, 8);
			AmountPerDay AmountPerDay17 = new AmountPerDay(240.0, "25/09/2010", "Product Group 3", 25, 9);
			AmountPerDay AmountPerDay18 = new AmountPerDay(10.0, "14/02/2010", "Product Group 1", 14, 2);
			AmountPerDay AmountPerDay19 = new AmountPerDay(150.0, "15/04/2010", "Product Group 3", 15, 4);
			AmountPerDay AmountPerDay20 = new AmountPerDay(50.0, "04/01/2010", "Product Group 2", 4, 1);
			AmountPerDay AmountPerDay21 = new AmountPerDay(180.0, "06/01/2010", "Product Group 1", 6, 1);
			AmountPerDay AmountPerDay22 = new AmountPerDay(90.0, "09/01/2010", "Product Group 1", 9, 1);
			AmountPerDay AmountPerDay23 = new AmountPerDay(30.0, "22/07/2010", "Product Group 2", 22, 7);
			AmountPerDay AmountPerDay24 = new AmountPerDay(240.0, "07/08/2010", "Product Group 3", 7, 8);
			AmountPerDay AmountPerDay25 = new AmountPerDay(15.0, "22/09/2010", "Product Group 1", 22, 9);
			AmountPerDay AmountPerDay26 = new AmountPerDay(40.0, "10/10/2010", "Product Group 1", 10, 10);
			AmountPerDay AmountPerDay27 = new AmountPerDay(50.0, "09/01/2010", "Product Group 3", 9, 1);
			AmountPerDay AmountPerDay28 = new AmountPerDay(190.0, "02/09/2010", "Product Group 1", 2, 9);
			AmountPerDay AmountPerDay29 = new AmountPerDay(280.0, "24/01/2010", "Product Group 2", 24, 1);
			AmountPerDay AmountPerDay30 = new AmountPerDay(130.0, "20/11/2010", "Product Group 2", 20, 11);
			AmountPerDay AmountPerDay31 = new AmountPerDay(40.0, "22/12/2010", "Product Group 2", 22, 12);
			AmountPerDay AmountPerDay32 = new AmountPerDay(90.0, "25/10/2010", "Product Group 3", 25, 10);
			AmountPerDay AmountPerDay33 = new AmountPerDay(170.0, "23/02/2010", "Product Group 3", 23, 2);
			AmountPerDay AmountPerDay34 = new AmountPerDay(250.0, "13/01/2010", "Product Group 1", 13, 1);
			AmountPerDay AmountPerDay35 = new AmountPerDay(30.0, "29/01/2010", "Product Group 2", 29, 1);
			AmountPerDay AmountPerDay36 = new AmountPerDay(130.0, "17/09/2010", "Product Group 2", 17, 9);
			AmountPerDay AmountPerDay37 = new AmountPerDay(240.0, "15/01/2010", "Product Group 1", 15, 1);
			AmountPerDay AmountPerDay38 = new AmountPerDay(40.0, "19/08/2010", "Product Group 1", 19, 8);
			AmountPerDay AmountPerDay39 = new AmountPerDay(70.0, "27/01/2010", "Product Group 3", 27, 1);
			AmountPerDay AmountPerDay40 = new AmountPerDay(200.0, "30/06/2010", "Product Group 1", 30, 6);
			AmountPerDay AmountPerDay41 = new AmountPerDay(30.0, "15/06/2010", "Product Group 2", 15, 6);
			AmountPerDay AmountPerDay42 = new AmountPerDay(240.0, "14/04/2010", "Product Group 3", 14, 4);
			AmountPerDay AmountPerDay43 = new AmountPerDay(15.0, "17/03/2010", "Product Group 1", 17, 3);
			AmountPerDay AmountPerDay44 = new AmountPerDay(30.0, "14/02/2010", "Product Group 3", 14, 2);
			
			//ProductGroup ProductGroup1 = new ProductGroup(new String[]{"Food", "Liquor", "Animal Food"}, "Product Group 1");
			//ProductGroup ProductGroup2 = new ProductGroup(new String[]{"Notebook", "Book", "Writing Accessories"}, "Product Group 2");
			//ProductGroup ProductGroup3 = new ProductGroup(new String[]{"Cosmetics", "Shampoo", "Cream", "Lotion"}, "Product Group 3");
			//ProductGroup ProductGroup4 = new ProductGroup(new String[]{"Utensils", "Detergent", "Maintenance Supplies"}, "Product Group 4");
			
			
			
			//Inserting Nodes (Atoms) into the Graph
			HGHandle SupplierHandle1 = resellerChainGraph.add(Supplier1);
			HGHandle SupplierHandle2 = resellerChainGraph.add(Supplier2);
			
			HGHandle MarketingDivisionHandel1 = resellerChainGraph.add(MarketingDivision1);
			
			HGHandle HeadquarterMilanoHandle = resellerChainGraph.add(HeadquarterMilano);
			HGHandle HeadquarterRomaHandle = resellerChainGraph.add(HeadquarterRoma);
			HGHandle HeadquarterGenovaHandle = resellerChainGraph.add(HeadquarterGenova);
			HGHandle HeadquarterVeronaHandle = resellerChainGraph.add(HeadquarterVerona);
			
			HGHandle WarehouseMilanoHandle1 = resellerChainGraph.add(WarehouseMilano1);
			HGHandle WarehouseMilanoHandle2 = resellerChainGraph.add(WarehouseMilano2);
			HGHandle WarehouseRomaHandle = resellerChainGraph.add(WarehouseRoma);
			HGHandle WarehouseGenovaHandle = resellerChainGraph.add(WarehouseGenova);
			HGHandle WarehouseVeronaHandle = resellerChainGraph.add(WarehouseVerona);
			
			HGHandle ResellerMilanoHandle1 = resellerChainGraph.add(ResellerMilano1);
			HGHandle ResellerMilanoHandle2 = resellerChainGraph.add(ResellerMilano2);
			HGHandle ResellerMilanoHandle3 = resellerChainGraph.add(ResellerMilano3);
			HGHandle ResellerRomaHandle1 = resellerChainGraph.add(ResellerRoma1);
			HGHandle ResellerRomaHandle2 = resellerChainGraph.add(ResellerRoma2);
			HGHandle ResellerRomaHandle3 = resellerChainGraph.add(ResellerRoma3);
			HGHandle ResellerRomaHandle4 = resellerChainGraph.add(ResellerRoma4);
			HGHandle ResellerRomaHandle5 = resellerChainGraph.add(ResellerRoma5);
			HGHandle ResellerGenovaHandle = resellerChainGraph.add(ResellerGenova);
			HGHandle ResellerVeronaHandle = resellerChainGraph.add(ResellerVerona);
			
			HGHandle LoyaltyProgramHandle1 = resellerChainGraph.add(LoyaltyProgram1);
			HGHandle LoyaltyProgramHandle2 = resellerChainGraph.add(LoyaltyProgram2);
			
			HGHandle CustomerHandle1 = resellerChainGraph.add(Customer1);
			HGHandle CustomerHandle2 = resellerChainGraph.add(Customer2);
			HGHandle CustomerHandle3 = resellerChainGraph.add(Customer3);
			HGHandle CustomerHandle4 = resellerChainGraph.add(Customer4);
			HGHandle CustomerHandle5 = resellerChainGraph.add(Customer5);
			HGHandle CustomerHandle6 = resellerChainGraph.add(Customer6);
			HGHandle CustomerHandle7 = resellerChainGraph.add(Customer7);
			HGHandle CustomerHandle8 = resellerChainGraph.add(Customer8);
			HGHandle CustomerHandle9 = resellerChainGraph.add(Customer9);
			HGHandle CustomerHandle10 = resellerChainGraph.add(Customer10);
			HGHandle CustomerHandle11 = resellerChainGraph.add(Customer11);
			HGHandle CustomerHandle12 = resellerChainGraph.add(Customer12);
			HGHandle CustomerHandle13 = resellerChainGraph.add(Customer13);
			HGHandle CustomerHandle14 = resellerChainGraph.add(Customer14);
			
			HGHandle AmountPerDayHandle1 = resellerChainGraph.add(AmountPerDay1);
			HGHandle AmountPerDayHandle2 = resellerChainGraph.add(AmountPerDay2);
			HGHandle AmountPerDayHandle3 = resellerChainGraph.add(AmountPerDay3);
			HGHandle AmountPerDayHandle4 = resellerChainGraph.add(AmountPerDay4);
			HGHandle AmountPerDayHandle5 = resellerChainGraph.add(AmountPerDay5);
			HGHandle AmountPerDayHandle6 = resellerChainGraph.add(AmountPerDay6);
			HGHandle AmountPerDayHandle7 = resellerChainGraph.add(AmountPerDay7);
			HGHandle AmountPerDayHandle8 = resellerChainGraph.add(AmountPerDay8);
			HGHandle AmountPerDayHandle9 = resellerChainGraph.add(AmountPerDay9);
			HGHandle AmountPerDayHandle10 = resellerChainGraph.add(AmountPerDay10);
			HGHandle AmountPerDayHandle11 = resellerChainGraph.add(AmountPerDay11);
			HGHandle AmountPerDayHandle12 = resellerChainGraph.add(AmountPerDay12);
			HGHandle AmountPerDayHandle13 = resellerChainGraph.add(AmountPerDay13);
			HGHandle AmountPerDayHandle14 = resellerChainGraph.add(AmountPerDay14);
			HGHandle AmountPerDayHandle15 = resellerChainGraph.add(AmountPerDay15);
			HGHandle AmountPerDayHandle16 = resellerChainGraph.add(AmountPerDay16);
			HGHandle AmountPerDayHandle17 = resellerChainGraph.add(AmountPerDay17);
			HGHandle AmountPerDayHandle18 = resellerChainGraph.add(AmountPerDay18);
			HGHandle AmountPerDayHandle19 = resellerChainGraph.add(AmountPerDay19);
			HGHandle AmountPerDayHandle20 = resellerChainGraph.add(AmountPerDay20);
			HGHandle AmountPerDayHandle21 = resellerChainGraph.add(AmountPerDay21);
			HGHandle AmountPerDayHandle22 = resellerChainGraph.add(AmountPerDay22);
			HGHandle AmountPerDayHandle23 = resellerChainGraph.add(AmountPerDay23);
			HGHandle AmountPerDayHandle24 = resellerChainGraph.add(AmountPerDay24);
			HGHandle AmountPerDayHandle25 = resellerChainGraph.add(AmountPerDay25);
			HGHandle AmountPerDayHandle26 = resellerChainGraph.add(AmountPerDay26);
			HGHandle AmountPerDayHandle27 = resellerChainGraph.add(AmountPerDay27);
			HGHandle AmountPerDayHandle28 = resellerChainGraph.add(AmountPerDay28);
			HGHandle AmountPerDayHandle29 = resellerChainGraph.add(AmountPerDay29);
			HGHandle AmountPerDayHandle30 = resellerChainGraph.add(AmountPerDay30);
			HGHandle AmountPerDayHandle31 = resellerChainGraph.add(AmountPerDay31);
			HGHandle AmountPerDayHandle32 = resellerChainGraph.add(AmountPerDay32);
			HGHandle AmountPerDayHandle33 = resellerChainGraph.add(AmountPerDay33);
			HGHandle AmountPerDayHandle34 = resellerChainGraph.add(AmountPerDay34);
			HGHandle AmountPerDayHandle35 = resellerChainGraph.add(AmountPerDay35);
			HGHandle AmountPerDayHandle36 = resellerChainGraph.add(AmountPerDay36);
			HGHandle AmountPerDayHandle37 = resellerChainGraph.add(AmountPerDay37);
			HGHandle AmountPerDayHandle38 = resellerChainGraph.add(AmountPerDay38);
			HGHandle AmountPerDayHandle39 = resellerChainGraph.add(AmountPerDay39);
			HGHandle AmountPerDayHandle40 = resellerChainGraph.add(AmountPerDay40);
			HGHandle AmountPerDayHandle41 = resellerChainGraph.add(AmountPerDay41);
			HGHandle AmountPerDayHandle42 = resellerChainGraph.add(AmountPerDay42);
			HGHandle AmountPerDayHandle43 = resellerChainGraph.add(AmountPerDay43);
			HGHandle AmountPerDayHandle44 = resellerChainGraph.add(AmountPerDay44);
			
			
			//Defining the relationships between the nodes of the graph
			HGValueLink Supplier_MarketingDivision1 = new HGValueLink("Provides With Products", SupplierHandle1, MarketingDivisionHandel1);
			HGValueLink Supplier_MarketingDivision2 = new HGValueLink("Provides With Products", SupplierHandle2, MarketingDivisionHandel1);
			
			resellerChainGraph.add(Supplier_MarketingDivision1);
			resellerChainGraph.add(Supplier_MarketingDivision2);
			
			HGValueLink MarketingDivision_Headquarter1 = new HGValueLink("Sends Products", MarketingDivisionHandel1, HeadquarterMilanoHandle);
			HGValueLink MarketingDivision_Headquarter2 = new HGValueLink("Sends Products", MarketingDivisionHandel1, HeadquarterRomaHandle);
			HGValueLink MarketingDivision_Headquarter3 = new HGValueLink("Sends Products", MarketingDivisionHandel1, HeadquarterGenovaHandle);
			HGValueLink MarketingDivision_Headquarter4 = new HGValueLink("Sends Products", MarketingDivisionHandel1, HeadquarterVeronaHandle);
			
			resellerChainGraph.add(MarketingDivision_Headquarter1);
			resellerChainGraph.add(MarketingDivision_Headquarter2);
			resellerChainGraph.add(MarketingDivision_Headquarter3);
			resellerChainGraph.add(MarketingDivision_Headquarter4);
			
			HGValueLink Headquarter_Warehouse1 = new HGValueLink("Keeps In", HeadquarterMilanoHandle, WarehouseMilanoHandle1);
			HGValueLink Headquarter_Warehouse2 = new HGValueLink("Keeps In", HeadquarterMilanoHandle, WarehouseMilanoHandle2);
			HGValueLink Headquarter_Warehouse3 = new HGValueLink("Keeps In", HeadquarterRomaHandle, WarehouseRomaHandle);
			HGValueLink Headquarter_Warehouse4 = new HGValueLink("Keeps In", HeadquarterGenovaHandle, WarehouseGenovaHandle);
			HGValueLink Headquarter_Warehouse5 = new HGValueLink("Keeps In", HeadquarterVeronaHandle, WarehouseVeronaHandle);
			
			resellerChainGraph.add(Headquarter_Warehouse1);
			resellerChainGraph.add(Headquarter_Warehouse2);
			resellerChainGraph.add(Headquarter_Warehouse3);
			resellerChainGraph.add(Headquarter_Warehouse4);
			resellerChainGraph.add(Headquarter_Warehouse5);
			
			HGValueLink Warehouse_Reseller1 = new HGValueLink("Transports To", WarehouseMilanoHandle1, ResellerMilanoHandle1);
			HGValueLink Warehouse_Reseller2 = new HGValueLink("Transports To", WarehouseMilanoHandle1, ResellerMilanoHandle2);
			HGValueLink Warehouse_Reseller3 = new HGValueLink("Transports To", WarehouseMilanoHandle2, ResellerMilanoHandle2);
			HGValueLink Warehouse_Reseller4 = new HGValueLink("Transports To", WarehouseRomaHandle, ResellerRomaHandle1);
			HGValueLink Warehouse_Reseller5 = new HGValueLink("Transports To", WarehouseRomaHandle, ResellerRomaHandle2);
			HGValueLink Warehouse_Reseller6 = new HGValueLink("Transports To", WarehouseGenovaHandle, ResellerGenovaHandle);
			HGValueLink Warehouse_Reseller7 = new HGValueLink("Transports To", WarehouseVeronaHandle, ResellerVeronaHandle);
			
			resellerChainGraph.add(Warehouse_Reseller1);
			resellerChainGraph.add(Warehouse_Reseller2);
			resellerChainGraph.add(Warehouse_Reseller3);
			resellerChainGraph.add(Warehouse_Reseller4);
			resellerChainGraph.add(Warehouse_Reseller5);
			resellerChainGraph.add(Warehouse_Reseller6);
			resellerChainGraph.add(Warehouse_Reseller7);
			
			
			HGValueLink Reseller_Reseller1 = new HGValueLink("Send Products To", ResellerMilanoHandle1, ResellerMilanoHandle3);
			HGValueLink Reseller_Reseller2 = new HGValueLink("Send Products To", ResellerMilanoHandle2, ResellerMilanoHandle3);
			HGValueLink Reseller_Reseller3 = new HGValueLink("Send Products To", ResellerRomaHandle1, ResellerRomaHandle3);
			HGValueLink Reseller_Reseller4 = new HGValueLink("Send Products To", ResellerRomaHandle2, ResellerRomaHandle5);
			HGValueLink Reseller_Reseller5 = new HGValueLink("Send Products To", ResellerRomaHandle3, ResellerRomaHandle5);
			HGValueLink Reseller_Reseller6 = new HGValueLink("Send Products To", ResellerRomaHandle3, ResellerRomaHandle4);
			
			resellerChainGraph.add(Reseller_Reseller1);
			resellerChainGraph.add(Reseller_Reseller2);
			resellerChainGraph.add(Reseller_Reseller3);
			resellerChainGraph.add(Reseller_Reseller4);
			resellerChainGraph.add(Reseller_Reseller5);
			resellerChainGraph.add(Reseller_Reseller6);
			
			HGValueLink Reseller_LoyaltyProgram1 = new HGValueLink("Offer", ResellerMilanoHandle1, LoyaltyProgramHandle1);
			HGValueLink Reseller_LoyaltyProgram2 = new HGValueLink("Offer", ResellerMilanoHandle2, LoyaltyProgramHandle1);
			HGValueLink Reseller_LoyaltyProgram3 = new HGValueLink("Offer", ResellerMilanoHandle3, LoyaltyProgramHandle1);
			HGValueLink Reseller_LoyaltyProgram4 = new HGValueLink("Offer", ResellerRomaHandle1, LoyaltyProgramHandle1);
			HGValueLink Reseller_LoyaltyProgram5 = new HGValueLink("Offer", ResellerRomaHandle2, LoyaltyProgramHandle1);
			HGValueLink Reseller_LoyaltyProgram6 = new HGValueLink("Offer", ResellerGenovaHandle, LoyaltyProgramHandle1);
			HGValueLink Reseller_LoyaltyProgram7 = new HGValueLink("Offer", ResellerVeronaHandle, LoyaltyProgramHandle1);
			HGValueLink Reseller_LoyaltyProgram8 = new HGValueLink("Offer", ResellerMilanoHandle1, LoyaltyProgramHandle2);
			HGValueLink Reseller_LoyaltyProgram9 = new HGValueLink("Offer", ResellerRomaHandle3, LoyaltyProgramHandle1);
			HGValueLink Reseller_LoyaltyProgram10 = new HGValueLink("Offer", ResellerRomaHandle3, LoyaltyProgramHandle2);
			HGValueLink Reseller_LoyaltyProgram11 = new HGValueLink("Offer", ResellerRomaHandle4, LoyaltyProgramHandle2);
			HGValueLink Reseller_LoyaltyProgram12 = new HGValueLink("Offer", ResellerRomaHandle5, LoyaltyProgramHandle2);
			
			resellerChainGraph.add(Reseller_LoyaltyProgram1);
			resellerChainGraph.add(Reseller_LoyaltyProgram2);
			resellerChainGraph.add(Reseller_LoyaltyProgram3);
			resellerChainGraph.add(Reseller_LoyaltyProgram4);
			resellerChainGraph.add(Reseller_LoyaltyProgram5);
			resellerChainGraph.add(Reseller_LoyaltyProgram6);
			resellerChainGraph.add(Reseller_LoyaltyProgram7);
			resellerChainGraph.add(Reseller_LoyaltyProgram8);
			resellerChainGraph.add(Reseller_LoyaltyProgram9);
			resellerChainGraph.add(Reseller_LoyaltyProgram10);
			resellerChainGraph.add(Reseller_LoyaltyProgram11);
			resellerChainGraph.add(Reseller_LoyaltyProgram12);
			
			HGValueLink Customer_Reseller1 = new HGValueLink("Buys", CustomerHandle1, ResellerGenovaHandle);
			HGValueLink Customer_Reseller2 = new HGValueLink("Buys", CustomerHandle2, ResellerMilanoHandle1);
			HGValueLink Customer_Reseller3 = new HGValueLink("Buys", CustomerHandle2, ResellerMilanoHandle2);
			HGValueLink Customer_Reseller4 = new HGValueLink("Buys", CustomerHandle2, ResellerMilanoHandle3);
			HGValueLink Customer_Reseller5 = new HGValueLink("Buys", CustomerHandle3, ResellerMilanoHandle1);
			HGValueLink Customer_Reseller6 = new HGValueLink("Buys", CustomerHandle3, ResellerMilanoHandle2);
			HGValueLink Customer_Reseller7 = new HGValueLink("Buys", CustomerHandle3, ResellerMilanoHandle3);
			HGValueLink Customer_Reseller8 = new HGValueLink("Buys", CustomerHandle4, ResellerRomaHandle1);
			HGValueLink Customer_Reseller9 = new HGValueLink("Buys", CustomerHandle4, ResellerRomaHandle2);
			HGValueLink Customer_Reseller10 = new HGValueLink("Buys", CustomerHandle4, ResellerRomaHandle3);
			HGValueLink Customer_Reseller11 = new HGValueLink("Buys", CustomerHandle4, ResellerRomaHandle4);
			HGValueLink Customer_Reseller12 = new HGValueLink("Buys", CustomerHandle5, ResellerVeronaHandle);
			HGValueLink Customer_Reseller13 = new HGValueLink("Buys", CustomerHandle6, ResellerRomaHandle1);
			HGValueLink Customer_Reseller14 = new HGValueLink("Buys", CustomerHandle5, ResellerRomaHandle2);
			HGValueLink Customer_Reseller15 = new HGValueLink("Buys", CustomerHandle6, ResellerRomaHandle3);
			HGValueLink Customer_Reseller16 = new HGValueLink("Buys", CustomerHandle6, ResellerRomaHandle4);
			HGValueLink Customer_Reseller17 = new HGValueLink("Buys", CustomerHandle6, ResellerRomaHandle5);
			HGValueLink Customer_Reseller18 = new HGValueLink("Buys", CustomerHandle7, ResellerMilanoHandle1);
			HGValueLink Customer_Reseller19 = new HGValueLink("Buys", CustomerHandle7, ResellerMilanoHandle2);
			HGValueLink Customer_Reseller20 = new HGValueLink("Buys", CustomerHandle7, ResellerMilanoHandle3);
			HGValueLink Customer_Reseller21 = new HGValueLink("Buys", CustomerHandle8, ResellerGenovaHandle);
			HGValueLink Customer_Reseller22 = new HGValueLink("Buys", CustomerHandle9, ResellerRomaHandle1);
			HGValueLink Customer_Reseller23 = new HGValueLink("Buys", CustomerHandle9, ResellerRomaHandle2);
			HGValueLink Customer_Reseller24 = new HGValueLink("Buys", CustomerHandle9, ResellerRomaHandle3);
			HGValueLink Customer_Reseller25 = new HGValueLink("Buys", CustomerHandle9, ResellerRomaHandle4);
			HGValueLink Customer_Reseller26 = new HGValueLink("Buys", CustomerHandle9, ResellerRomaHandle5);
			HGValueLink Customer_Reseller27 = new HGValueLink("Buys", CustomerHandle10, ResellerRomaHandle1);
			HGValueLink Customer_Reseller28 = new HGValueLink("Buys", CustomerHandle10, ResellerRomaHandle2);
			HGValueLink Customer_Reseller29 = new HGValueLink("Buys", CustomerHandle10, ResellerRomaHandle4);
			HGValueLink Customer_Reseller30 = new HGValueLink("Buys", CustomerHandle10, ResellerRomaHandle5);
			HGValueLink Customer_Reseller31 = new HGValueLink("Buys", CustomerHandle11, ResellerVeronaHandle);
			HGValueLink Customer_Reseller32 = new HGValueLink("Buys", CustomerHandle12, ResellerMilanoHandle1);
			HGValueLink Customer_Reseller33 = new HGValueLink("Buys", CustomerHandle12, ResellerMilanoHandle2);
			HGValueLink Customer_Reseller34 = new HGValueLink("Buys", CustomerHandle12, ResellerMilanoHandle3);
			HGValueLink Customer_Reseller35 = new HGValueLink("Buys", CustomerHandle13, ResellerRomaHandle1);
			HGValueLink Customer_Reseller36 = new HGValueLink("Buys", CustomerHandle13, ResellerRomaHandle5);
			HGValueLink Customer_Reseller37 = new HGValueLink("Buys", CustomerHandle13, ResellerRomaHandle4);
			HGValueLink Customer_Reseller38 = new HGValueLink("Buys", CustomerHandle14, ResellerMilanoHandle2);
			HGValueLink Customer_Reseller39 = new HGValueLink("Buys", CustomerHandle14, ResellerMilanoHandle3);
			
			resellerChainGraph.add(Customer_Reseller1);
			resellerChainGraph.add(Customer_Reseller2);
			resellerChainGraph.add(Customer_Reseller3);
			resellerChainGraph.add(Customer_Reseller4);
			resellerChainGraph.add(Customer_Reseller5);
			resellerChainGraph.add(Customer_Reseller6);
			resellerChainGraph.add(Customer_Reseller7);
			resellerChainGraph.add(Customer_Reseller8);
			resellerChainGraph.add(Customer_Reseller9);
			resellerChainGraph.add(Customer_Reseller10);
			resellerChainGraph.add(Customer_Reseller11);
			resellerChainGraph.add(Customer_Reseller12);
			resellerChainGraph.add(Customer_Reseller13);
			resellerChainGraph.add(Customer_Reseller14);
			resellerChainGraph.add(Customer_Reseller15);
			resellerChainGraph.add(Customer_Reseller16);
			resellerChainGraph.add(Customer_Reseller17);
			resellerChainGraph.add(Customer_Reseller18);
			resellerChainGraph.add(Customer_Reseller19);
			resellerChainGraph.add(Customer_Reseller20);
			resellerChainGraph.add(Customer_Reseller21);
			resellerChainGraph.add(Customer_Reseller22);
			resellerChainGraph.add(Customer_Reseller23);
			resellerChainGraph.add(Customer_Reseller24);
			resellerChainGraph.add(Customer_Reseller25);
			resellerChainGraph.add(Customer_Reseller26);
			resellerChainGraph.add(Customer_Reseller27);
			resellerChainGraph.add(Customer_Reseller28);
			resellerChainGraph.add(Customer_Reseller29);
			resellerChainGraph.add(Customer_Reseller30);
			resellerChainGraph.add(Customer_Reseller31);
			resellerChainGraph.add(Customer_Reseller32);
			resellerChainGraph.add(Customer_Reseller33);
			resellerChainGraph.add(Customer_Reseller34); 
			resellerChainGraph.add(Customer_Reseller35);
			resellerChainGraph.add(Customer_Reseller36);
			resellerChainGraph.add(Customer_Reseller37);
			resellerChainGraph.add(Customer_Reseller38);
			resellerChainGraph.add(Customer_Reseller39);
			
			HGValueLink Customer_AmountPerDay1 = new HGValueLink("Does Shopping", CustomerHandle1, AmountPerDayHandle1);
			HGValueLink Customer_AmountPerDay2 = new HGValueLink("Does Shopping", CustomerHandle1, AmountPerDayHandle2);
			HGValueLink Customer_AmountPerDay3 = new HGValueLink("Does Shopping", CustomerHandle1, AmountPerDayHandle3);
			HGValueLink Customer_AmountPerDay4 = new HGValueLink("Does Shopping", CustomerHandle1, AmountPerDayHandle4);
			HGValueLink Customer_AmountPerDay5 = new HGValueLink("Does Shopping", CustomerHandle1, AmountPerDayHandle14);
			HGValueLink Customer_AmountPerDay6 = new HGValueLink("Does Shopping", CustomerHandle1, AmountPerDayHandle41);
			HGValueLink Customer_AmountPerDay7 = new HGValueLink("Does Shopping", CustomerHandle1, AmountPerDayHandle40);
			HGValueLink Customer_AmountPerDay8 = new HGValueLink("Does Shopping", CustomerHandle1, AmountPerDayHandle42);
			HGValueLink Customer_AmountPerDay9 = new HGValueLink("Does Shopping", CustomerHandle1, AmountPerDayHandle44);
			HGValueLink Customer_AmountPerDay10 = new HGValueLink("Does Shopping", CustomerHandle1, AmountPerDayHandle34);
			HGValueLink Customer_AmountPerDay11 = new HGValueLink("Does Shopping", CustomerHandle1, AmountPerDayHandle24);
			HGValueLink Customer_AmountPerDay12 = new HGValueLink("Does Shopping", CustomerHandle1, AmountPerDayHandle12);
			HGValueLink Customer_AmountPerDay13 = new HGValueLink("Does Shopping", CustomerHandle1, AmountPerDayHandle22);
			HGValueLink Customer_AmountPerDay14 = new HGValueLink("Does Shopping", CustomerHandle1, AmountPerDayHandle32);
			HGValueLink Customer_AmountPerDay15 = new HGValueLink("Does Shopping", CustomerHandle1, AmountPerDayHandle15);
			HGValueLink Customer_AmountPerDay16 = new HGValueLink("Does Shopping", CustomerHandle1, AmountPerDayHandle25);
			HGValueLink Customer_AmountPerDay17 = new HGValueLink("Does Shopping", CustomerHandle1, AmountPerDayHandle17);
			HGValueLink Customer_AmountPerDay18 = new HGValueLink("Does Shopping", CustomerHandle1, AmountPerDayHandle27);
			HGValueLink Customer_AmountPerDay19 = new HGValueLink("Does Shopping", CustomerHandle1, AmountPerDayHandle39);
			HGValueLink Customer_AmountPerDay20 = new HGValueLink("Does Shopping", CustomerHandle1, AmountPerDayHandle19);
			HGValueLink Customer_AmountPerDay21 = new HGValueLink("Does Shopping", CustomerHandle1, AmountPerDayHandle13);
			HGValueLink Customer_AmountPerDay22 = new HGValueLink("Does Shopping", CustomerHandle1, AmountPerDayHandle23);
			
			resellerChainGraph.add(Customer_AmountPerDay1);
			resellerChainGraph.add(Customer_AmountPerDay2);
			resellerChainGraph.add(Customer_AmountPerDay3);
			resellerChainGraph.add(Customer_AmountPerDay4);
			resellerChainGraph.add(Customer_AmountPerDay5);
			resellerChainGraph.add(Customer_AmountPerDay6);
			resellerChainGraph.add(Customer_AmountPerDay7);
			resellerChainGraph.add(Customer_AmountPerDay8);
			resellerChainGraph.add(Customer_AmountPerDay9);
			resellerChainGraph.add(Customer_AmountPerDay10);
			resellerChainGraph.add(Customer_AmountPerDay11);
			resellerChainGraph.add(Customer_AmountPerDay12);
			resellerChainGraph.add(Customer_AmountPerDay13);
			resellerChainGraph.add(Customer_AmountPerDay14);
			resellerChainGraph.add(Customer_AmountPerDay15);
			resellerChainGraph.add(Customer_AmountPerDay16);
			resellerChainGraph.add(Customer_AmountPerDay17);
			resellerChainGraph.add(Customer_AmountPerDay18);
			resellerChainGraph.add(Customer_AmountPerDay19);
			resellerChainGraph.add(Customer_AmountPerDay20);
			resellerChainGraph.add(Customer_AmountPerDay21);
			resellerChainGraph.add(Customer_AmountPerDay22);
			
			HGValueLink Customer_AmountPerDay23 = new HGValueLink("Does Shopping", CustomerHandle2, AmountPerDayHandle5);
			HGValueLink Customer_AmountPerDay24 = new HGValueLink("Does Shopping", CustomerHandle2, AmountPerDayHandle6);
			HGValueLink Customer_AmountPerDay25 = new HGValueLink("Does Shopping", CustomerHandle2, AmountPerDayHandle7);
			HGValueLink Customer_AmountPerDay26 = new HGValueLink("Does Shopping", CustomerHandle2, AmountPerDayHandle8);
			HGValueLink Customer_AmountPerDay27 = new HGValueLink("Does Shopping", CustomerHandle2, AmountPerDayHandle18);
			HGValueLink Customer_AmountPerDay28 = new HGValueLink("Does Shopping", CustomerHandle2, AmountPerDayHandle28);
			HGValueLink Customer_AmountPerDay29 = new HGValueLink("Does Shopping", CustomerHandle2, AmountPerDayHandle13);
			HGValueLink Customer_AmountPerDay30 = new HGValueLink("Does Shopping", CustomerHandle2, AmountPerDayHandle33);
			HGValueLink Customer_AmountPerDay31 = new HGValueLink("Does Shopping", CustomerHandle2, AmountPerDayHandle27);
			HGValueLink Customer_AmountPerDay32 = new HGValueLink("Does Shopping", CustomerHandle2, AmountPerDayHandle36);
			
			resellerChainGraph.add(Customer_AmountPerDay23);
			resellerChainGraph.add(Customer_AmountPerDay24);
			resellerChainGraph.add(Customer_AmountPerDay25);
			resellerChainGraph.add(Customer_AmountPerDay26);
			resellerChainGraph.add(Customer_AmountPerDay27);
			resellerChainGraph.add(Customer_AmountPerDay28);
			resellerChainGraph.add(Customer_AmountPerDay29);
			resellerChainGraph.add(Customer_AmountPerDay30);
			resellerChainGraph.add(Customer_AmountPerDay31);
			resellerChainGraph.add(Customer_AmountPerDay32);
			
			HGValueLink Customer_AmountPerDay33 = new HGValueLink("Does Shopping", CustomerHandle3, AmountPerDayHandle9);
			HGValueLink Customer_AmountPerDay34 = new HGValueLink("Does Shopping", CustomerHandle3, AmountPerDayHandle10);
			HGValueLink Customer_AmountPerDay35 = new HGValueLink("Does Shopping", CustomerHandle3, AmountPerDayHandle11);
			HGValueLink Customer_AmountPerDay36 = new HGValueLink("Does Shopping", CustomerHandle3, AmountPerDayHandle12);
			HGValueLink Customer_AmountPerDay37 = new HGValueLink("Does Shopping", CustomerHandle3, AmountPerDayHandle13);
			HGValueLink Customer_AmountPerDay38 = new HGValueLink("Does Shopping", CustomerHandle3, AmountPerDayHandle14);
			HGValueLink Customer_AmountPerDay39 = new HGValueLink("Does Shopping", CustomerHandle3, AmountPerDayHandle15);
			HGValueLink Customer_AmountPerDay40 = new HGValueLink("Does Shopping", CustomerHandle3, AmountPerDayHandle16);
			HGValueLink Customer_AmountPerDay41 = new HGValueLink("Does Shopping", CustomerHandle3, AmountPerDayHandle22);
			HGValueLink Customer_AmountPerDay42 = new HGValueLink("Does Shopping", CustomerHandle3, AmountPerDayHandle23);
			HGValueLink Customer_AmountPerDay43 = new HGValueLink("Does Shopping", CustomerHandle3, AmountPerDayHandle24);
			HGValueLink Customer_AmountPerDay44 = new HGValueLink("Does Shopping", CustomerHandle3, AmountPerDayHandle25);
			HGValueLink Customer_AmountPerDay45 = new HGValueLink("Does Shopping", CustomerHandle3, AmountPerDayHandle26);
			HGValueLink Customer_AmountPerDay46 = new HGValueLink("Does Shopping", CustomerHandle3, AmountPerDayHandle27);
			HGValueLink Customer_AmountPerDay47 = new HGValueLink("Does Shopping", CustomerHandle3, AmountPerDayHandle18);
			
			resellerChainGraph.add(Customer_AmountPerDay33);
			resellerChainGraph.add(Customer_AmountPerDay34);
			resellerChainGraph.add(Customer_AmountPerDay35);
			resellerChainGraph.add(Customer_AmountPerDay36);
			resellerChainGraph.add(Customer_AmountPerDay37);
			resellerChainGraph.add(Customer_AmountPerDay38);
			resellerChainGraph.add(Customer_AmountPerDay39);
			resellerChainGraph.add(Customer_AmountPerDay40);
			resellerChainGraph.add(Customer_AmountPerDay41);
			resellerChainGraph.add(Customer_AmountPerDay42);
			resellerChainGraph.add(Customer_AmountPerDay43);
			resellerChainGraph.add(Customer_AmountPerDay44);
			resellerChainGraph.add(Customer_AmountPerDay45);
			resellerChainGraph.add(Customer_AmountPerDay46);
			resellerChainGraph.add(Customer_AmountPerDay47);
			
			HGValueLink Customer_AmountPerDay48 = new HGValueLink("Does Shopping", CustomerHandle4, AmountPerDayHandle13);
			HGValueLink Customer_AmountPerDay49 = new HGValueLink("Does Shopping", CustomerHandle4, AmountPerDayHandle14);
			HGValueLink Customer_AmountPerDay50 = new HGValueLink("Does Shopping", CustomerHandle4, AmountPerDayHandle15);
			
			resellerChainGraph.add(Customer_AmountPerDay48);
			resellerChainGraph.add(Customer_AmountPerDay49);
			resellerChainGraph.add(Customer_AmountPerDay50);
			
			HGValueLink Customer_AmountPerDay51 = new HGValueLink("Does Shopping", CustomerHandle5, AmountPerDayHandle16);
			HGValueLink Customer_AmountPerDay52 = new HGValueLink("Does Shopping", CustomerHandle5, AmountPerDayHandle17);
			HGValueLink Customer_AmountPerDay53 = new HGValueLink("Does Shopping", CustomerHandle5, AmountPerDayHandle18);
			
			resellerChainGraph.add(Customer_AmountPerDay51);
			resellerChainGraph.add(Customer_AmountPerDay52);
			resellerChainGraph.add(Customer_AmountPerDay53);
			
			HGValueLink Customer_AmountPerDay54 = new HGValueLink("Does Shopping", CustomerHandle6, AmountPerDayHandle19);
			HGValueLink Customer_AmountPerDay55 = new HGValueLink("Does Shopping", CustomerHandle6, AmountPerDayHandle20);
			HGValueLink Customer_AmountPerDay56 = new HGValueLink("Does Shopping", CustomerHandle6, AmountPerDayHandle21);
			HGValueLink Customer_AmountPerDay57 = new HGValueLink("Does Shopping", CustomerHandle6, AmountPerDayHandle39);
			HGValueLink Customer_AmountPerDay58 = new HGValueLink("Does Shopping", CustomerHandle6, AmountPerDayHandle29);
			HGValueLink Customer_AmountPerDay59 = new HGValueLink("Does Shopping", CustomerHandle6, AmountPerDayHandle12);
			HGValueLink Customer_AmountPerDay60 = new HGValueLink("Does Shopping", CustomerHandle6, AmountPerDayHandle42);
			HGValueLink Customer_AmountPerDay61 = new HGValueLink("Does Shopping", CustomerHandle6, AmountPerDayHandle32);
			HGValueLink Customer_AmountPerDay62 = new HGValueLink("Does Shopping", CustomerHandle6, AmountPerDayHandle29);
			HGValueLink Customer_AmountPerDay63 = new HGValueLink("Does Shopping", CustomerHandle6, AmountPerDayHandle26);
			HGValueLink Customer_AmountPerDay64 = new HGValueLink("Does Shopping", CustomerHandle6, AmountPerDayHandle25);
			
			resellerChainGraph.add(Customer_AmountPerDay54);
			resellerChainGraph.add(Customer_AmountPerDay55);
			resellerChainGraph.add(Customer_AmountPerDay56);
			resellerChainGraph.add(Customer_AmountPerDay57);
			resellerChainGraph.add(Customer_AmountPerDay58);
			resellerChainGraph.add(Customer_AmountPerDay59);
			resellerChainGraph.add(Customer_AmountPerDay60);
			resellerChainGraph.add(Customer_AmountPerDay61);
			resellerChainGraph.add(Customer_AmountPerDay62);
			resellerChainGraph.add(Customer_AmountPerDay63);
			resellerChainGraph.add(Customer_AmountPerDay64);
			
			HGValueLink Customer_AmountPerDay65 = new HGValueLink("Does Shopping", CustomerHandle7, AmountPerDayHandle23);
			HGValueLink Customer_AmountPerDay66 = new HGValueLink("Does Shopping", CustomerHandle7, AmountPerDayHandle24);
			HGValueLink Customer_AmountPerDay67 = new HGValueLink("Does Shopping", CustomerHandle7, AmountPerDayHandle25);
			HGValueLink Customer_AmountPerDay68 = new HGValueLink("Does Shopping", CustomerHandle7, AmountPerDayHandle26);
			
			resellerChainGraph.add(Customer_AmountPerDay65);
			resellerChainGraph.add(Customer_AmountPerDay66);
			resellerChainGraph.add(Customer_AmountPerDay67);
			resellerChainGraph.add(Customer_AmountPerDay68);
			
			HGValueLink Customer_AmountPerDay69 = new HGValueLink("Does Shopping", CustomerHandle8, AmountPerDayHandle27);
			HGValueLink Customer_AmountPerDay70 = new HGValueLink("Does Shopping", CustomerHandle8, AmountPerDayHandle28);
			HGValueLink Customer_AmountPerDay71 = new HGValueLink("Does Shopping", CustomerHandle8, AmountPerDayHandle29);
			HGValueLink Customer_AmountPerDay72 = new HGValueLink("Does Shopping", CustomerHandle8, AmountPerDayHandle30);
			
			resellerChainGraph.add(Customer_AmountPerDay69);
			resellerChainGraph.add(Customer_AmountPerDay70);
			resellerChainGraph.add(Customer_AmountPerDay71);
			resellerChainGraph.add(Customer_AmountPerDay72);
			
			HGValueLink Customer_AmountPerDay73 = new HGValueLink("Does Shopping", CustomerHandle9, AmountPerDayHandle31);
			HGValueLink Customer_AmountPerDay74 = new HGValueLink("Does Shopping", CustomerHandle9, AmountPerDayHandle32);
			HGValueLink Customer_AmountPerDay75 = new HGValueLink("Does Shopping", CustomerHandle9, AmountPerDayHandle33);
			HGValueLink Customer_AmountPerDay76 = new HGValueLink("Does Shopping", CustomerHandle9, AmountPerDayHandle34);
			HGValueLink Customer_AmountPerDay77 = new HGValueLink("Does Shopping", CustomerHandle9, AmountPerDayHandle36);
			HGValueLink Customer_AmountPerDay78 = new HGValueLink("Does Shopping", CustomerHandle9, AmountPerDayHandle37);
			HGValueLink Customer_AmountPerDay79 = new HGValueLink("Does Shopping", CustomerHandle9, AmountPerDayHandle38);
			HGValueLink Customer_AmountPerDay80 = new HGValueLink("Does Shopping", CustomerHandle9, AmountPerDayHandle39);
			HGValueLink Customer_AmountPerDay81 = new HGValueLink("Does Shopping", CustomerHandle9, AmountPerDayHandle40);
			HGValueLink Customer_AmountPerDay82 = new HGValueLink("Does Shopping", CustomerHandle9, AmountPerDayHandle41);
			HGValueLink Customer_AmountPerDay83 = new HGValueLink("Does Shopping", CustomerHandle9, AmountPerDayHandle42);
			HGValueLink Customer_AmountPerDay84 = new HGValueLink("Does Shopping", CustomerHandle9, AmountPerDayHandle43);
			HGValueLink Customer_AmountPerDay85 = new HGValueLink("Does Shopping", CustomerHandle9, AmountPerDayHandle44);
			HGValueLink Customer_AmountPerDay86 = new HGValueLink("Does Shopping", CustomerHandle9, AmountPerDayHandle10);
			HGValueLink Customer_AmountPerDay87 = new HGValueLink("Does Shopping", CustomerHandle9, AmountPerDayHandle20);
			HGValueLink Customer_AmountPerDay88 = new HGValueLink("Does Shopping", CustomerHandle9, AmountPerDayHandle11);
			HGValueLink Customer_AmountPerDay89 = new HGValueLink("Does Shopping", CustomerHandle9, AmountPerDayHandle21);
			HGValueLink Customer_AmountPerDay90 = new HGValueLink("Does Shopping", CustomerHandle9, AmountPerDayHandle12);
			HGValueLink Customer_AmountPerDay91 = new HGValueLink("Does Shopping", CustomerHandle9, AmountPerDayHandle22);
			HGValueLink Customer_AmountPerDay92 = new HGValueLink("Does Shopping", CustomerHandle9, AmountPerDayHandle13);
			HGValueLink Customer_AmountPerDay93 = new HGValueLink("Does Shopping", CustomerHandle9, AmountPerDayHandle23);
			HGValueLink Customer_AmountPerDay94 = new HGValueLink("Does Shopping", CustomerHandle9, AmountPerDayHandle14);
			HGValueLink Customer_AmountPerDay95 = new HGValueLink("Does Shopping", CustomerHandle9, AmountPerDayHandle24);
			
			resellerChainGraph.add(Customer_AmountPerDay73);
			resellerChainGraph.add(Customer_AmountPerDay74);
			resellerChainGraph.add(Customer_AmountPerDay75);
			resellerChainGraph.add(Customer_AmountPerDay76);
			resellerChainGraph.add(Customer_AmountPerDay77);
			resellerChainGraph.add(Customer_AmountPerDay78);
			resellerChainGraph.add(Customer_AmountPerDay79);
			resellerChainGraph.add(Customer_AmountPerDay80);
			resellerChainGraph.add(Customer_AmountPerDay81);
			resellerChainGraph.add(Customer_AmountPerDay82);
			resellerChainGraph.add(Customer_AmountPerDay83);
			resellerChainGraph.add(Customer_AmountPerDay84);
			resellerChainGraph.add(Customer_AmountPerDay85);
			resellerChainGraph.add(Customer_AmountPerDay86);
			resellerChainGraph.add(Customer_AmountPerDay87);
			resellerChainGraph.add(Customer_AmountPerDay88);
			resellerChainGraph.add(Customer_AmountPerDay89);
			resellerChainGraph.add(Customer_AmountPerDay90);
			resellerChainGraph.add(Customer_AmountPerDay91);
			resellerChainGraph.add(Customer_AmountPerDay92);
			resellerChainGraph.add(Customer_AmountPerDay93);
			resellerChainGraph.add(Customer_AmountPerDay94);
			resellerChainGraph.add(Customer_AmountPerDay95);
			
			HGValueLink Customer_AmountPerDay96 = new HGValueLink("Does Shopping", CustomerHandle10, AmountPerDayHandle36);
			HGValueLink Customer_AmountPerDay97 = new HGValueLink("Does Shopping", CustomerHandle10, AmountPerDayHandle37);
			HGValueLink Customer_AmountPerDay98 = new HGValueLink("Does Shopping", CustomerHandle10, AmountPerDayHandle38);
			HGValueLink Customer_AmountPerDay99 = new HGValueLink("Does Shopping", CustomerHandle10, AmountPerDayHandle39);
			HGValueLink Customer_AmountPerDay100 = new HGValueLink("Does Shopping", CustomerHandle10, AmountPerDayHandle40);
			
			resellerChainGraph.add(Customer_AmountPerDay96);
			resellerChainGraph.add(Customer_AmountPerDay97);
			resellerChainGraph.add(Customer_AmountPerDay98);
			resellerChainGraph.add(Customer_AmountPerDay99);
			resellerChainGraph.add(Customer_AmountPerDay100);
			
			HGValueLink Customer_AmountPerDay101 = new HGValueLink("Does Shopping", CustomerHandle11, AmountPerDayHandle41);
			HGValueLink Customer_AmountPerDay102 = new HGValueLink("Does Shopping", CustomerHandle11, AmountPerDayHandle42);
			HGValueLink Customer_AmountPerDay103 = new HGValueLink("Does Shopping", CustomerHandle11, AmountPerDayHandle43);
			HGValueLink Customer_AmountPerDay104 = new HGValueLink("Does Shopping", CustomerHandle11, AmountPerDayHandle44);
			HGValueLink Customer_AmountPerDay105 = new HGValueLink("Does Shopping", CustomerHandle11, AmountPerDayHandle1);
			HGValueLink Customer_AmountPerDay106 = new HGValueLink("Does Shopping", CustomerHandle11, AmountPerDayHandle4);
			HGValueLink Customer_AmountPerDay107 = new HGValueLink("Does Shopping", CustomerHandle11, AmountPerDayHandle15);
			HGValueLink Customer_AmountPerDay108 = new HGValueLink("Does Shopping", CustomerHandle11, AmountPerDayHandle14);
			HGValueLink Customer_AmountPerDay109 = new HGValueLink("Does Shopping", CustomerHandle11, AmountPerDayHandle13);
			HGValueLink Customer_AmountPerDay110 = new HGValueLink("Does Shopping", CustomerHandle11, AmountPerDayHandle2);
			HGValueLink Customer_AmountPerDay111 = new HGValueLink("Does Shopping", CustomerHandle11, AmountPerDayHandle22);
			HGValueLink Customer_AmountPerDay112 = new HGValueLink("Does Shopping", CustomerHandle11, AmountPerDayHandle32);
			HGValueLink Customer_AmountPerDay113 = new HGValueLink("Does Shopping", CustomerHandle11, AmountPerDayHandle37);
			HGValueLink Customer_AmountPerDay114 = new HGValueLink("Does Shopping", CustomerHandle11, AmountPerDayHandle27);
			HGValueLink Customer_AmountPerDay115 = new HGValueLink("Does Shopping", CustomerHandle11, AmountPerDayHandle17);
			HGValueLink Customer_AmountPerDay116 = new HGValueLink("Does Shopping", CustomerHandle11, AmountPerDayHandle7);
			HGValueLink Customer_AmountPerDay117 = new HGValueLink("Does Shopping", CustomerHandle11, AmountPerDayHandle12);
			HGValueLink Customer_AmountPerDay118 = new HGValueLink("Does Shopping", CustomerHandle11, AmountPerDayHandle35);
			HGValueLink Customer_AmountPerDay119 = new HGValueLink("Does Shopping", CustomerHandle11, AmountPerDayHandle15);
			HGValueLink Customer_AmountPerDay120 = new HGValueLink("Does Shopping", CustomerHandle11, AmountPerDayHandle25);
			HGValueLink Customer_AmountPerDay121 = new HGValueLink("Does Shopping", CustomerHandle11, AmountPerDayHandle6);
			HGValueLink Customer_AmountPerDay122 = new HGValueLink("Does Shopping", CustomerHandle11, AmountPerDayHandle16);
			HGValueLink Customer_AmountPerDay123 = new HGValueLink("Does Shopping", CustomerHandle11, AmountPerDayHandle26);
			HGValueLink Customer_AmountPerDay124 = new HGValueLink("Does Shopping", CustomerHandle11, AmountPerDayHandle27);
			HGValueLink Customer_AmountPerDay125 = new HGValueLink("Does Shopping", CustomerHandle11, AmountPerDayHandle36);
			HGValueLink Customer_AmountPerDay126 = new HGValueLink("Does Shopping", CustomerHandle11, AmountPerDayHandle18);
			
			resellerChainGraph.add(Customer_AmountPerDay101);
			resellerChainGraph.add(Customer_AmountPerDay102);
			resellerChainGraph.add(Customer_AmountPerDay103);
			resellerChainGraph.add(Customer_AmountPerDay104);
			resellerChainGraph.add(Customer_AmountPerDay105);
			resellerChainGraph.add(Customer_AmountPerDay106);
			resellerChainGraph.add(Customer_AmountPerDay107);
			resellerChainGraph.add(Customer_AmountPerDay108);
			resellerChainGraph.add(Customer_AmountPerDay109);
			resellerChainGraph.add(Customer_AmountPerDay110);
			resellerChainGraph.add(Customer_AmountPerDay111);
			resellerChainGraph.add(Customer_AmountPerDay112);
			resellerChainGraph.add(Customer_AmountPerDay113);
			resellerChainGraph.add(Customer_AmountPerDay114);
			resellerChainGraph.add(Customer_AmountPerDay115);
			resellerChainGraph.add(Customer_AmountPerDay116);
			resellerChainGraph.add(Customer_AmountPerDay117);
			resellerChainGraph.add(Customer_AmountPerDay118);
			resellerChainGraph.add(Customer_AmountPerDay119);
			resellerChainGraph.add(Customer_AmountPerDay120);
			resellerChainGraph.add(Customer_AmountPerDay121);
			resellerChainGraph.add(Customer_AmountPerDay122);
			resellerChainGraph.add(Customer_AmountPerDay123);
			resellerChainGraph.add(Customer_AmountPerDay124);
			resellerChainGraph.add(Customer_AmountPerDay125);
			resellerChainGraph.add(Customer_AmountPerDay126);
			
			HGValueLink Customer_AmountPerDay127 = new HGValueLink("Does Shopping", CustomerHandle12, AmountPerDayHandle1);
			HGValueLink Customer_AmountPerDay128 = new HGValueLink("Does Shopping", CustomerHandle12, AmountPerDayHandle2);
			HGValueLink Customer_AmountPerDay129 = new HGValueLink("Does Shopping", CustomerHandle12, AmountPerDayHandle3);
			HGValueLink Customer_AmountPerDay130 = new HGValueLink("Does Shopping", CustomerHandle12, AmountPerDayHandle4);
			HGValueLink Customer_AmountPerDay131 = new HGValueLink("Does Shopping", CustomerHandle12, AmountPerDayHandle14);
			HGValueLink Customer_AmountPerDay132 = new HGValueLink("Does Shopping", CustomerHandle12, AmountPerDayHandle13);
			HGValueLink Customer_AmountPerDay133 = new HGValueLink("Does Shopping", CustomerHandle12, AmountPerDayHandle17);
			HGValueLink Customer_AmountPerDay134 = new HGValueLink("Does Shopping", CustomerHandle12, AmountPerDayHandle18);
			HGValueLink Customer_AmountPerDay135 = new HGValueLink("Does Shopping", CustomerHandle12, AmountPerDayHandle19);
			HGValueLink Customer_AmountPerDay136 = new HGValueLink("Does Shopping", CustomerHandle12, AmountPerDayHandle20);
			HGValueLink Customer_AmountPerDay137 = new HGValueLink("Does Shopping", CustomerHandle12, AmountPerDayHandle21);
			HGValueLink Customer_AmountPerDay138 = new HGValueLink("Does Shopping", CustomerHandle12, AmountPerDayHandle22);
			HGValueLink Customer_AmountPerDay139 = new HGValueLink("Does Shopping", CustomerHandle12, AmountPerDayHandle23);
			HGValueLink Customer_AmountPerDay140 = new HGValueLink("Does Shopping", CustomerHandle12, AmountPerDayHandle24);
			HGValueLink Customer_AmountPerDay141 = new HGValueLink("Does Shopping", CustomerHandle12, AmountPerDayHandle25);
			HGValueLink Customer_AmountPerDay142 = new HGValueLink("Does Shopping", CustomerHandle12, AmountPerDayHandle26);
			HGValueLink Customer_AmountPerDay143 = new HGValueLink("Does Shopping", CustomerHandle12, AmountPerDayHandle27);
			
			resellerChainGraph.add(Customer_AmountPerDay127);
			resellerChainGraph.add(Customer_AmountPerDay128);
			resellerChainGraph.add(Customer_AmountPerDay129);
			resellerChainGraph.add(Customer_AmountPerDay130);
			resellerChainGraph.add(Customer_AmountPerDay131);
			resellerChainGraph.add(Customer_AmountPerDay132);
			resellerChainGraph.add(Customer_AmountPerDay133);
			resellerChainGraph.add(Customer_AmountPerDay134);
			resellerChainGraph.add(Customer_AmountPerDay135);
			resellerChainGraph.add(Customer_AmountPerDay136);
			resellerChainGraph.add(Customer_AmountPerDay137);
			resellerChainGraph.add(Customer_AmountPerDay138);
			resellerChainGraph.add(Customer_AmountPerDay139);
			resellerChainGraph.add(Customer_AmountPerDay140);
			resellerChainGraph.add(Customer_AmountPerDay141);
			resellerChainGraph.add(Customer_AmountPerDay142);
			resellerChainGraph.add(Customer_AmountPerDay143);
			
			HGValueLink Customer_AmountPerDay144 = new HGValueLink("Does Shopping", CustomerHandle13, AmountPerDayHandle19);
			HGValueLink Customer_AmountPerDay145 = new HGValueLink("Does Shopping", CustomerHandle13, AmountPerDayHandle30);
			HGValueLink Customer_AmountPerDay146 = new HGValueLink("Does Shopping", CustomerHandle13, AmountPerDayHandle15);
			HGValueLink Customer_AmountPerDay147 = new HGValueLink("Does Shopping", CustomerHandle13, AmountPerDayHandle1);
			HGValueLink Customer_AmountPerDay148 = new HGValueLink("Does Shopping", CustomerHandle13, AmountPerDayHandle14);
			HGValueLink Customer_AmountPerDay149 = new HGValueLink("Does Shopping", CustomerHandle13, AmountPerDayHandle22);
			HGValueLink Customer_AmountPerDay150 = new HGValueLink("Does Shopping", CustomerHandle13, AmountPerDayHandle27);
			HGValueLink Customer_AmountPerDay151 = new HGValueLink("Does Shopping", CustomerHandle13, AmountPerDayHandle40);
			HGValueLink Customer_AmountPerDay152 = new HGValueLink("Does Shopping", CustomerHandle13, AmountPerDayHandle42);
			HGValueLink Customer_AmountPerDay153 = new HGValueLink("Does Shopping", CustomerHandle13, AmountPerDayHandle15);
			HGValueLink Customer_AmountPerDay154 = new HGValueLink("Does Shopping", CustomerHandle13, AmountPerDayHandle18);
			HGValueLink Customer_AmountPerDay155 = new HGValueLink("Does Shopping", CustomerHandle13, AmountPerDayHandle28);
			HGValueLink Customer_AmountPerDay156 = new HGValueLink("Does Shopping", CustomerHandle13, AmountPerDayHandle38);
			HGValueLink Customer_AmountPerDay157 = new HGValueLink("Does Shopping", CustomerHandle13, AmountPerDayHandle37);
			HGValueLink Customer_AmountPerDay158 = new HGValueLink("Does Shopping", CustomerHandle13, AmountPerDayHandle14);
			HGValueLink Customer_AmountPerDay159 = new HGValueLink("Does Shopping", CustomerHandle13, AmountPerDayHandle13);
			
			resellerChainGraph.add(Customer_AmountPerDay144);
			resellerChainGraph.add(Customer_AmountPerDay145);
			resellerChainGraph.add(Customer_AmountPerDay146);
			resellerChainGraph.add(Customer_AmountPerDay147);
			resellerChainGraph.add(Customer_AmountPerDay148);
			resellerChainGraph.add(Customer_AmountPerDay149);
			resellerChainGraph.add(Customer_AmountPerDay150);
			resellerChainGraph.add(Customer_AmountPerDay151);
			resellerChainGraph.add(Customer_AmountPerDay152);
			resellerChainGraph.add(Customer_AmountPerDay153);
			resellerChainGraph.add(Customer_AmountPerDay154);
			resellerChainGraph.add(Customer_AmountPerDay155);
			resellerChainGraph.add(Customer_AmountPerDay156);
			resellerChainGraph.add(Customer_AmountPerDay157);
			resellerChainGraph.add(Customer_AmountPerDay158);
			resellerChainGraph.add(Customer_AmountPerDay159);
			
			HGValueLink Customer_AmountPerDay160 = new HGValueLink("Does Shopping", CustomerHandle14, AmountPerDayHandle6);
			HGValueLink Customer_AmountPerDay161 = new HGValueLink("Does Shopping", CustomerHandle14, AmountPerDayHandle14);
			HGValueLink Customer_AmountPerDay162 = new HGValueLink("Does Shopping", CustomerHandle14, AmountPerDayHandle13);
			HGValueLink Customer_AmountPerDay163 = new HGValueLink("Does Shopping", CustomerHandle14, AmountPerDayHandle17);
			HGValueLink Customer_AmountPerDay164 = new HGValueLink("Does Shopping", CustomerHandle14, AmountPerDayHandle41);
			HGValueLink Customer_AmountPerDay165 = new HGValueLink("Does Shopping", CustomerHandle14, AmountPerDayHandle40);
			HGValueLink Customer_AmountPerDay166 = new HGValueLink("Does Shopping", CustomerHandle14, AmountPerDayHandle39);
			HGValueLink Customer_AmountPerDay167 = new HGValueLink("Does Shopping", CustomerHandle14, AmountPerDayHandle37);
			HGValueLink Customer_AmountPerDay168 = new HGValueLink("Does Shopping", CustomerHandle14, AmountPerDayHandle26);
			HGValueLink Customer_AmountPerDay169 = new HGValueLink("Does Shopping", CustomerHandle14, AmountPerDayHandle25);
			HGValueLink Customer_AmountPerDay170 = new HGValueLink("Does Shopping", CustomerHandle14, AmountPerDayHandle9);
			HGValueLink Customer_AmountPerDay171 = new HGValueLink("Does Shopping", CustomerHandle14, AmountPerDayHandle5);
			HGValueLink Customer_AmountPerDay172 = new HGValueLink("Does Shopping", CustomerHandle14, AmountPerDayHandle1);
			HGValueLink Customer_AmountPerDay173 = new HGValueLink("Does Shopping", CustomerHandle14, AmountPerDayHandle10);
			HGValueLink Customer_AmountPerDay174 = new HGValueLink("Does Shopping", CustomerHandle14, AmountPerDayHandle11);
			HGValueLink Customer_AmountPerDay175 = new HGValueLink("Does Shopping", CustomerHandle14, AmountPerDayHandle12);
			HGValueLink Customer_AmountPerDay176 = new HGValueLink("Does Shopping", CustomerHandle14, AmountPerDayHandle34);
			HGValueLink Customer_AmountPerDay177 = new HGValueLink("Does Shopping", CustomerHandle14, AmountPerDayHandle35);
			HGValueLink Customer_AmountPerDay178 = new HGValueLink("Does Shopping", CustomerHandle14, AmountPerDayHandle44);
			HGValueLink Customer_AmountPerDay179 = new HGValueLink("Does Shopping", CustomerHandle14, AmountPerDayHandle29);
			HGValueLink Customer_AmountPerDay180 = new HGValueLink("Does Shopping", CustomerHandle14, AmountPerDayHandle43);
			HGValueLink Customer_AmountPerDay181 = new HGValueLink("Does Shopping", CustomerHandle14, AmountPerDayHandle22);
			HGValueLink Customer_AmountPerDay182 = new HGValueLink("Does Shopping", CustomerHandle14, AmountPerDayHandle19);
			HGValueLink Customer_AmountPerDay183 = new HGValueLink("Does Shopping", CustomerHandle14, AmountPerDayHandle16);
			HGValueLink Customer_AmountPerDay184 = new HGValueLink("Does Shopping", CustomerHandle14, AmountPerDayHandle15);
			
			resellerChainGraph.add(Customer_AmountPerDay160);
			resellerChainGraph.add(Customer_AmountPerDay161);
			resellerChainGraph.add(Customer_AmountPerDay162);
			resellerChainGraph.add(Customer_AmountPerDay163);
			resellerChainGraph.add(Customer_AmountPerDay164);
			resellerChainGraph.add(Customer_AmountPerDay165);
			resellerChainGraph.add(Customer_AmountPerDay166);
			resellerChainGraph.add(Customer_AmountPerDay167);
			resellerChainGraph.add(Customer_AmountPerDay168);
			resellerChainGraph.add(Customer_AmountPerDay169);
			resellerChainGraph.add(Customer_AmountPerDay170);
			resellerChainGraph.add(Customer_AmountPerDay171);
			resellerChainGraph.add(Customer_AmountPerDay172);
			resellerChainGraph.add(Customer_AmountPerDay173);
			resellerChainGraph.add(Customer_AmountPerDay174);
			resellerChainGraph.add(Customer_AmountPerDay175);
			resellerChainGraph.add(Customer_AmountPerDay176);
			resellerChainGraph.add(Customer_AmountPerDay177);
			resellerChainGraph.add(Customer_AmountPerDay178);
			resellerChainGraph.add(Customer_AmountPerDay179);
			resellerChainGraph.add(Customer_AmountPerDay180);
			resellerChainGraph.add(Customer_AmountPerDay181);
			resellerChainGraph.add(Customer_AmountPerDay182);
			resellerChainGraph.add(Customer_AmountPerDay183);
			resellerChainGraph.add(Customer_AmountPerDay184);
			
			
			//Updates:
			
			//Update the graph-database and set new values for Amount of 
			//purchase of products of Product Group 1, by Customer 1 on 22/01/2010.
			
/*			HGQueryCondition FindCustomer1 = new And(
					new AtomTypeCondition(Customer.class),
					new AtomPartCondition(new String[]{"name"}, "Customer 1", ComparisonOperator.EQ)
			);
			
			HGSearchResult rs1 = resellerChainGraph.find(FindCustomer1);

			Customer C1 = new Customer();
			
			while (rs1.hasNext()) {
				HGHandle current = (HGHandle) rs1.next();
				C1 = resellerChainGraph.get(current);
			}
			rs1.close();
			
			AmountPerDay customerPaymentOfDay = new AmountPerDay();
			List links = (List)hg.getAll(resellerChainGraph,hg.incident(resellerChainGraph.getHandle(C1)));
			for(int i=0; i<links.size(); i++){
				HGValueLink l1 = (HGValueLink)links.get(i);
				HGQueryCondition FindCustomerPaymentsOfDay = new And(
						new AtomTypeCondition(AmountPerDay.class),
						new AtomPartCondition(new String[]{"date"}, "22/01/2010", ComparisonOperator.EQ),
						new AtomPartCondition(new String[]{"productGroup"}, "Product Group 1", ComparisonOperator.EQ),
						hg.target(resellerChainGraph.getHandle(l1))
				);
				HGSearchResult rs3 = resellerChainGraph.find(FindCustomerPaymentsOfDay);
				while (rs3.hasNext()) {
					HGHandle current = (HGHandle) rs3.next();
					AmountPerDay x = resellerChainGraph.get(current);
					if(x != null){
						customerPaymentOfDay = x;
					}
				}
			}
			customerPaymentOfDay.setAmount(200);
			resellerChainGraph.update(customerPaymentOfDay);
*/
			//***************************************************************************************************
			//	Update the graph database and Group for customers older than 30 who 
			// had purchased product group 3 in Milano, set them as Group 10.
			
	/*		HGQueryCondition FindCustomers30Milano = new And(
					new AtomTypeCondition(Customer.class),
					new AtomPartCondition(new String[]{"age"}, 30, ComparisonOperator.GTE),
					new AtomPartCondition(new String[]{"location"}, "Milano", ComparisonOperator.EQ)
			);
			HGSearchResult rs12 = resellerChainGraph.find(FindCustomers30Milano);
			ArrayList Customers30Milano = new ArrayList<Customer>();
			while (rs12.hasNext()) {
				HGHandle current = (HGHandle) rs12.next();
				Customers30Milano.add((Customer) resellerChainGraph.get(current));
			}
			//For each customer who is younger than 25 years old:
			for(int i=0; i<Customers30Milano.size(); i++)
			{
				Customer TempCustomer30Milano = (Customer)Customers30Milano.get(i);
				List allLinksCustomers30Milano = (List)hg.getAll(resellerChainGraph,
						hg.incident(resellerChainGraph.getHandle(Customers30Milano.get(i))));
				//List of payments for the current customer
				ArrayList Customer30MilanoPayments = new ArrayList<AmountPerDay>();
				for(int j=0; j<allLinksCustomers30Milano.size(); j++){
					
					HGValueLink LinkCustomer25 = (HGValueLink)allLinksCustomers30Milano.get(j);
					
					if(LinkCustomer25.getValue() == "Does Shopping"){
						HGQueryCondition PaymentsOfCustomer25Query = new And(
								new AtomTypeCondition(AmountPerDay.class),
								new AtomPartCondition(new String[]{"productGroup"}, "Product Group 3", ComparisonOperator.EQ),
								hg.target(resellerChainGraph.getHandle(LinkCustomer25))
						);
						HGSearchResult rs13 = resellerChainGraph.find(PaymentsOfCustomer25Query);
						while(rs13.hasNext())
						{
							HGHandle current = (HGHandle)rs13.next();
							Customer30MilanoPayments.add((AmountPerDay)resellerChainGraph.get(current));		
						}
					}
					if(Customer30MilanoPayments.size()>0){
						
						TempCustomer30Milano.setGroup("Group 10");
						resellerChainGraph.update(TempCustomer30Milano);
					}
				}
			}
			HGQueryCondition FindCustomersGroup10 = new And(
					new AtomTypeCondition(Customer.class),
					new AtomPartCondition(new String[]{"group"}, "Group 10", ComparisonOperator.EQ));
			HGSearchResult rs14 = resellerChainGraph.find(FindCustomers30Milano);
			while (rs14.hasNext()) {
				HGHandle current = (HGHandle) rs14.next();
				Customer temp1 = (Customer) resellerChainGraph.get(current);
				System.out.print("Customer Name: "+ temp1.getName()+ " , location: " + temp1.getLocation());
				System.out.println(" , Group: "+ temp1.getGroup()+ " , Age: "+ temp1.getAge());
			}
			*/
			//***************************************************************************************************
			//Query: Customers who are affiliated to loyalty program 2 through Milano resellers on January.
			//1- Find the list of all customers
	/*		List AllCustomers = (List)hg.getAll(resellerChainGraph,new AtomTypeCondition(Customer.class));

			Customer C2 = new Customer();
			HGValueLink l2 = new HGValueLink();
			
			//2- For each Customer find the list of payments that customer has spent on Jan
			for(int i=0; i < AllCustomers.size(); i++){
				double sumOfPayment = 0;
				C2 = (Customer)AllCustomers.get(i);
				List links = (List)hg.getAll(resellerChainGraph,hg.incident(resellerChainGraph.getHandle(C2)));
				for(int j = 0; j < links.size(); j++){
					l2 = (HGValueLink)links.get(j);			
					HGQueryCondition CustomerPayments = new And(
									new AtomTypeCondition(AmountPerDay.class),
									new AtomPartCondition(new String[]{"month"}, 1, ComparisonOperator.EQ),
									hg.target(resellerChainGraph.getHandle(l2)));
					HGSearchResult rs4 = resellerChainGraph.find(CustomerPayments);
					while(rs4.hasNext())
					{
						HGHandle current = (HGHandle)rs4.next();
						AmountPerDay x1 = resellerChainGraph.get(current);
						if(x1 != null){
							sumOfPayment += x1.getAmount();
						}
					}
				}
				if(sumOfPayment>=200.0){
					System.out.print(C2.getName());
					System.out.print(" , ");
					System.out.println(sumOfPayment);
					System.out.println("--------------------------------------------------");
				}
				
			}*/
			//************************************************************************************
			
			//Find the resellers who send products to the other resellers and are located in Roma, 
			//find the number of other resellers they send product to and list them
			/*HGQueryCondition AllRomaResellersQuery = new And(
					new AtomTypeCondition(Reseller.class),
					new AtomPartCondition(new String[]{"location"}, "Roma", ComparisonOperator.EQ)
			);
			List AllRomaResellers = (List)hg.getAll(resellerChainGraph, AllRomaResellersQuery);
			//For Each Reseller
			for(int i=0; i<AllRomaResellers.size(); i++)
			{    
				Reseller r1 = (Reseller)AllRomaResellers.get(i);
				Set ResellerLinks = (Set)resellerChainGraph.getIncidenceSet(resellerChainGraph.getHandle(r1));
				Iterator linksIt = ResellerLinks.iterator();
				int arity = 0;
				ArrayList resellerList = new ArrayList<Reseller>();
				while(linksIt.hasNext())
				{
					HGHandle RHandle = (HGHandle)linksIt.next();
					HGValueLink x1 = resellerChainGraph.get(RHandle);
					if(x1.getValue()=="Send Products To")
					{
						arity++;
						HGQueryCondition FindAllTargetsQuery = new And(
							new AtomTypeCondition(Reseller.class),
							new Not(new AtomPartCondition(new String[] {"name"}, r1.getName(), ComparisonOperator.EQ)),
							hg.target(resellerChainGraph.getHandle(x1))
						);
						HGSearchResult rs5 = resellerChainGraph.find(FindAllTargetsQuery);
						while(rs5.hasNext())
						{
							HGHandle current = (HGHandle)rs5.next();
							resellerList.add((Reseller)resellerChainGraph.get(current));
						}
						
						rs5.close();
					}
				}
				if(resellerList.size()!= 0){
					System.out.print("Reseller Name: "+r1.getName());
					System.out.print(" , ");
					System.out.println(r1.getLocation());
					System.out.println("Arity" + ": "+ arity);
					System.out.println("List of resellers who sends products to: ");
					for(int j=0; j<resellerList.size(); j++){
						Reseller r5 = (Reseller)resellerList.get(j);
						System.out.println(r5.getName()+ " , "+ r5.getLocation()+" , ");
				    }
					System.out.println("-------------------------------------------");
				}
				
			}*/
			//************************************************************************************
			
			//Sales Statistics: Find the sales of product group 1 on January 2010 which were bought 
			//by customers of group 1 who they are more than 22 years old.
		/*	HGQueryCondition FindCustomerOfGroup1 = new And(
					new AtomTypeCondition(Customer.class),
					new AtomPartCondition(new String[]{"group"}, "Group 1", ComparisonOperator.EQ),
					new AtomPartCondition(new String[]{"age"}, 22, ComparisonOperator.GTE)
			);
			HGSearchResult rs6 = resellerChainGraph.find(FindCustomerOfGroup1);
			ArrayList CustomerGroup1 = new ArrayList<Customer>();
			while (rs6.hasNext()) {
				HGHandle current = (HGHandle) rs6.next();
				CustomerGroup1.add((Customer) resellerChainGraph.get(current));
			}
			//For each customer of group1 above the 22 years old:
			for(int i=0; i<CustomerGroup1.size(); i++)
			{
				List AllLinksCustomerGroup1 = (List)hg.getAll(resellerChainGraph,
						hg.incident(resellerChainGraph.getHandle(CustomerGroup1.get(i))));
				//List of payments for the current customer
				ArrayList CustomerGroup1Payments = new ArrayList<AmountPerDay>();
				
				for(int j=0; j<AllLinksCustomerGroup1.size(); j++){
					
					HGValueLink LinkCustomerGroup1 = (HGValueLink)AllLinksCustomerGroup1.get(j);
					
					if(LinkCustomerGroup1.getValue() == "Does Shopping"){
						HGQueryCondition PaymentsOfCustomerGroup1Query = new And(
								new AtomTypeCondition(AmountPerDay.class),
								new AtomPartCondition(new String[]{"month"}, 1, ComparisonOperator.EQ),
								new AtomPartCondition(new String[]{"productGroup"}, "Product Group 1", ComparisonOperator.EQ),
								hg.target(resellerChainGraph.getHandle(LinkCustomerGroup1))
						);
						HGSearchResult rs7 = resellerChainGraph.find(PaymentsOfCustomerGroup1Query);
						while(rs7.hasNext())
						{
							HGHandle current = (HGHandle)rs7.next();
							CustomerGroup1Payments.add((AmountPerDay)resellerChainGraph.get(current));		
						}
					}
				}
				Customer currentCustomer = (Customer)CustomerGroup1.get(i);
				System.out.print("Customer Name: "+ currentCustomer.getName()+ " , location: " + currentCustomer.getLocation());
				System.out.println(" , Group: "+ currentCustomer.getGroup()+ " , Age: "+ currentCustomer.getAge());
				for(int z = 0; z< CustomerGroup1Payments.size(); z++)
				{
					
					AmountPerDay currentPayment = (AmountPerDay) CustomerGroup1Payments.get(z);
					System.out.println("Payments: ");
					System.out.print("Amount: "+currentPayment.getAmount()+" , Product Group: "+ currentPayment.getProductGroup());
					System.out.println(" , Date: "+ currentPayment.getDate());
				}
				System.out.println("---------------------------------------------------");
			} */
			//********************************************************************************************
			
			//Find the total sales of product group 1 in Milano in year 2010
		/*	double TotalSales = 0.0;
			HGQueryCondition FindMilanoCustomers = new And(
					new AtomTypeCondition(Customer.class),
					new AtomPartCondition(new String[]{"location"}, "Milano", ComparisonOperator.EQ)
			);
			HGSearchResult rs8 = resellerChainGraph.find(FindMilanoCustomers);
			ArrayList MilanoCustomers = new ArrayList<Customer>();
			while (rs8.hasNext()) {
				HGHandle current = (HGHandle) rs8.next();
				MilanoCustomers.add((Customer) resellerChainGraph.get(current));
			}
			//For each customer in Milano:
			for(int i=0; i<MilanoCustomers.size(); i++)
			{
				List allLinksMilanoCustomers = (List)hg.getAll(resellerChainGraph,
						hg.incident(resellerChainGraph.getHandle(MilanoCustomers.get(i))));
				//List of payments for the current customer
				ArrayList MilanoCustomerPayments = new ArrayList<AmountPerDay>();
				
				for(int j=0; j<allLinksMilanoCustomers.size(); j++){
					
					HGValueLink LinkMilanoCustomer = (HGValueLink)allLinksMilanoCustomers.get(j);
					
					if(LinkMilanoCustomer.getValue() == "Does Shopping"){
						HGQueryCondition PaymentsOfMilanoCustomerQuery = new And(
								new AtomTypeCondition(AmountPerDay.class),
								new AtomPartCondition(new String[]{"productGroup"}, "Product Group 1", ComparisonOperator.EQ),
								hg.target(resellerChainGraph.getHandle(LinkMilanoCustomer))
						);
						HGSearchResult rs9 = resellerChainGraph.find(PaymentsOfMilanoCustomerQuery);
						while(rs9.hasNext())
						{
							HGHandle current = (HGHandle)rs9.next();
							MilanoCustomerPayments.add((AmountPerDay)resellerChainGraph.get(current));		
						}
					}
				}
				
				for(int z = 0; z< MilanoCustomerPayments.size(); z++)
				{	
					AmountPerDay currentPayment1 = (AmountPerDay) MilanoCustomerPayments.get(z);
					TotalSales += currentPayment1.getAmount();
				}
			}
			System.out.println("Total Sales of Product Group 1 in year 2010 in Milano: " + TotalSales);*/
			
			//**********************************************************************************
			
			//Find customers under the age 25 who have 
			//spent more than 200 Euro on Product Group1 in January 2010. 
			/*HGQueryCondition FindCustomers25 = new And(
					new AtomTypeCondition(Customer.class),
					new AtomPartCondition(new String[]{"age"}, 25, ComparisonOperator.LTE)
			);
			HGSearchResult rs10 = resellerChainGraph.find(FindCustomers25);
			ArrayList Customers25 = new ArrayList<Customer>();
			while (rs10.hasNext()) {
				HGHandle current = (HGHandle) rs10.next();
				Customers25.add((Customer) resellerChainGraph.get(current));
			}
			//For each customer who is younger than 25 years old:
			for(int i=0; i<Customers25.size(); i++)
			{
				double TotalCustomer5Payments =0.0;
				List allLinksCustomers25 = (List)hg.getAll(resellerChainGraph,
						hg.incident(resellerChainGraph.getHandle(Customers25.get(i))));
				//List of payments for the current customer
				ArrayList Customer25Payments = new ArrayList<AmountPerDay>();
				for(int j=0; j<allLinksCustomers25.size(); j++){
					
					HGValueLink LinkCustomer25 = (HGValueLink)allLinksCustomers25.get(j);
					
					if(LinkCustomer25.getValue() == "Does Shopping"){
						HGQueryCondition PaymentsOfCustomer25Query = new And(
								new AtomTypeCondition(AmountPerDay.class),
								new AtomPartCondition(new String[]{"productGroup"}, "Product Group 1", ComparisonOperator.EQ),
								new AtomPartCondition(new String[]{"month"}, 1, ComparisonOperator.EQ),
								hg.target(resellerChainGraph.getHandle(LinkCustomer25))
						);
						HGSearchResult rs11 = resellerChainGraph.find(PaymentsOfCustomer25Query);
						while(rs11.hasNext())
						{
							HGHandle current = (HGHandle)rs11.next();
							Customer25Payments.add((AmountPerDay)resellerChainGraph.get(current));		
						}
					}
				}
				for(int z = 0; z< Customer25Payments.size(); z++)
				{	
					AmountPerDay currentPayment1 = (AmountPerDay) Customer25Payments.get(z);
					TotalCustomer5Payments += currentPayment1.getAmount();
				}
				
				if(TotalCustomer5Payments >= 200.0){
					Customer currentCustomer5 = (Customer)Customers25.get(i);
					System.out.print("Customer Name: "+ currentCustomer5.getName()+ " , location: " + currentCustomer5.getLocation());
					System.out.println(" , Group: "+ currentCustomer5.getGroup()+ " , Age: "+ currentCustomer5.getAge());
					System.out.println("Total Payment For Product Group 1 on January 2010: "+ TotalCustomer5Payments);
					System.out.println("----------------------------------------------------------");
				}
			}*/
		}
		catch(Throwable t)
		{
			t.printStackTrace();
		}	
	}
}
