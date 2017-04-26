package nvt;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import nvt.beans.AdvertisementType;
import nvt.beans.Agent;
import nvt.beans.AgentRating;
import nvt.beans.Company;
import nvt.beans.HeatingType;
import nvt.beans.Image;
import nvt.beans.IndoorFeature;
import nvt.beans.Location;
import nvt.beans.OutdoorFeature;
import nvt.beans.RealEstate;
import nvt.beans.RealEstateComment;
import nvt.beans.RealEstateIndoors;
import nvt.beans.RealEstateOutdoors;
import nvt.beans.RealEstateRating;
import nvt.beans.RealEstateReport;
import nvt.beans.RealEstateType;
import nvt.beans.User;
import nvt.beans.WorkingTime;
import nvt.repository.AdvertisementTypeRepository;
import nvt.repository.AgentRatingRepository;
import nvt.repository.AgentRepository;
import nvt.repository.CompanyRepository;
import nvt.repository.HeatingTypeRepository;
import nvt.repository.ImageRepository;
import nvt.repository.IndoorFeatureRepository;
import nvt.repository.LocationRepository;
import nvt.repository.OutdoorFeatureRepository;
import nvt.repository.RealEstateCommentRepository;
import nvt.repository.RealEstateIndoorsRepository;
import nvt.repository.RealEstateOutdoorsRepository;
import nvt.repository.RealEstateRatingRepository;
import nvt.repository.RealEstateReportRepository;
import nvt.repository.RealEstateRepository;
import nvt.repository.RealEstateTypeRepository;
import nvt.repository.UserRepository;
import nvt.repository.WorkingTimeRepository;

@SpringBootApplication
public class NvtApplication implements CommandLineRunner {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	LocationRepository locationRepository;
	
	@Autowired
	WorkingTimeRepository workingTimeRepository;
	
	@Autowired
	CompanyRepository companyRepository;
	
	@Autowired
	AgentRepository agentRepository;
	
	@Autowired
	IndoorFeatureRepository indoorFeatureRepository;
	
	@Autowired
	OutdoorFeatureRepository outdoorFeatureRepository;
	
	@Autowired
	HeatingTypeRepository heatingTypeRepository;
	
	@Autowired
	RealEstateTypeRepository realEstateTypeRepository;
	
	@Autowired
	RealEstateRepository realEstateRepository;
	
	@Autowired 
	AdvertisementTypeRepository advertisementTypeRepository;
	
	@Autowired
	RealEstateCommentRepository realEstateCommentRepository;
	
	@Autowired
	RealEstateRatingRepository realEstateRatingRepository;
	
	@Autowired 
	RealEstateReportRepository realEstateReportRepository;
	
	@Autowired
	AgentRatingRepository agentRatingRepository;
	
	@Autowired
	RealEstateIndoorsRepository realEstateIndoorsRepository;
	
	@Autowired 
	RealEstateOutdoorsRepository realEstateOutdoorsRepository;
	
	@Autowired
	ImageRepository imageRepository;
	
	
	
	public static void main(String[] args) {
		
		SpringApplication.run(NvtApplication.class);
		
		System.out.println("\n\n\n\n\t\t\t\tIVANA");
	}

	
	
	@Override
	public void run(String... arg0) throws Exception {

	
		Image image11 = new Image("user1", "a");
		imageRepository.save(image11);
		Image image12 = new Image("user2", "a");
		imageRepository.save(image12);
		Set<Image> userImages = new HashSet<Image>();
		userImages.add(image11);
		userImages.add(image12);
		Image image13 = new Image("user3", "a");
		imageRepository.save(image13);
		Image image14 = new Image("user4", "a");
		imageRepository.save(image14);
		Image image15 = new Image("user5", "a");
		imageRepository.save(image15);
		Image image16 = new Image("user6", "a");
		imageRepository.save(image16);
		Image image17 = new Image("user7", "a");
		imageRepository.save(image17);
		Image image18 = new Image("user8", "a");
		imageRepository.save(image18);
		Image image19 = new Image("user9", "a");
		imageRepository.save(image19);
		Image image20 = new Image("user10", "a");
		imageRepository.save(image20);
		
		Image image31 = new Image("user1", "a");
		imageRepository.save(image31);
		Image image32 = new Image("user2", "a");
		imageRepository.save(image32);
		Image image33 = new Image("user3", "a");
		imageRepository.save(image33);
		Image image34 = new Image("user4", "a");
		imageRepository.save(image34);
		Image image35 = new Image("user5", "a");
		imageRepository.save(image35);
		Image image36 = new Image("user6", "a");
		imageRepository.save(image36);
		Image image37 = new Image("user7", "a");
		imageRepository.save(image37);
		Image image38 = new Image("user8", "a");
		imageRepository.save(image38);
		Image image39 = new Image("user9", "a");
		imageRepository.save(image39);
		Image image40 = new Image("user10", "a");
		imageRepository.save(image40);
		
		User user1 = new User("ivana.unitedforce@gmail.com", "josh", "123", "Josh", "Duhamel", "065-123-456");
		//userRepository.save(user1);
		User user2 = new User("iva17.igodina@gmail.com", "matthew", "123", "Matthew", "McConaughey", "065-456-789");
		//userRepository.save(user2);
		User user3 = new User("iva17.iigodina@gmail.com", "bradley", "123", "Bradley", "Cooper", "065-789-123");
		//userRepository.save(user3);
		User user4 = new User("iva17.iiigodina@gmail.com", "leonardo", "123", "Leonardo", "DiCaprio", "063-123-456");
		//userRepository.save(user4);
		User user5 = new User("blake.lively@gmail.com", "blake", "123", "Blake", "Lively", "063-456-789");
		//userRepository.save(user5);
		User user6 = new User("ryan.reynolds@gmail.com", "ryan", "123", "Ryan", "Reynolds", "063-789-123");
		//userRepository.save(user6);
		User user7 = new User("jessica.alba@gmail.com", "jessica", "123", "Jessica", "Alba", "062-123-456");
		//userRepository.save(user7);
		User user8 = new User("eva.mendes@gmail.com", "eva", "123", "Eva", "Mendes", "062-456-789");
		//userRepository.save(user8);
		User user9 = new User("jessica.alba@gmail.com", "jessica", "123", "Jessica", "Alba", "062-123-456");
		//userRepository.save(user9);
		User user10 = new User("natalie.portman@gmail.com", "natalie", "123", "Natalie", "Portman", "062-456-789");
		//userRepository.save(user10);
		
		
		
		User user11 = new User("lars.ulrich@gmail.com", "lars", "123", "Lars", "Urlich", "061-123-456");
		user11.setImages(userImages);
		user11.setLoged(true);
		userRepository.save(user11);
		User user12 = new User("james.hatfield@gmail.com", "james", "123", "James", "Hatfield", "061-456-789");
		userRepository.save(user12);
		User user13 = new User("til.linderman@gmail.com", "til", "123", "Til", "Linderman", "061-789-123");
		userRepository.save(user13);
		User user14 = new User("lily.aldridge@gmail.com", "lily", "123", "Lily", "Aldridge", "060-123-456");
		userRepository.save(user14);
		User user15 = new User("alessandra.ambrosio@gmail.com", "alessandra", "123", "Alessandra", "Ambrosio", "060-456-789");
		userRepository.save(user15);
		User user16 = new User("tyra.banks@gmail.com", "tyra", "123", "Tyra", "Banks", "060-789-123");
		userRepository.save(user16);
		User user17 = new User("stella.maxwell@gmail.com", "jessica", "123", "Jessica", "Alba", "066-123-456");
		userRepository.save(user17);
		User user18 = new User("behati.prinslo@gmail.com", "behati", "123", "Behati", "Prinslo", "066-456-789");
		userRepository.save(user18);
		User user19 = new User("martha.hunt@gmail.com", "martha", "123", "Martha", "Hunt", "069-123-456");
		userRepository.save(user19);
		User user20 = new User("romee.strijd@gmail.com", "romee", "123", "Romee", "Strijd", "069-456-789");
		userRepository.save(user20);
		
		Location location1 = new Location(44.8023505, 20.4719586, "Beograd", "Vračar", "Krunska", "11000");
		locationRepository.save(location1);
		Location location2 = new Location(44.8192953, 20.4486969, "Beograd", "Beton hala", "Karađorđeva 2-4", "11000");
		locationRepository.save(location2);
		Location location3 = new Location(44.8213953, 20.4665717, "Beograd", "Dorćol", "Žorža Klemansoa 10", "11000");
		locationRepository.save(location3);
		Location location4 = new Location(44.7970585, 20.4664927, "Beograd", "Vračar", "Bore Stankovića 17", "11000");
		locationRepository.save(location4);
		Location location5 = new Location(44.7888501, 20.4368326, "Beograd", "Senjak", "Andre Nikolića 1", "11000");
		locationRepository.save(location5);
		Location location6  = new Location(44.7664883, 20.4086425, "Beograd", "Julino brdo", "Katarine Bogdanović", "11000");
		locationRepository.save(location6);
		Location location7  = new Location(44.773251, 20.4550609, "Beograd", "Dedinje", "Vladimira Gaćinovića 15", "11000");
		locationRepository.save(location7);
		Location location8  = new Location(44.7780874, 20.4693926, "Beograd", "Voždovac", "Koste Jovanovića 87", "11000");
		locationRepository.save(location8);
		Location location9  = new Location(44.8150947, 20.5048786, "Beograd", "Karaburma", "Patrisa Lumumbe 4", "11000");
		locationRepository.save(location9);
		Location location10  = new Location(44.7823568, 20.4166448, "Beograd", "Banovo Brdo", "Požeška 40", "11000");
		locationRepository.save(location10);
		
		
		Location location11  = new Location(44.7972173, 20.4015128, "Beograd", "Neimar", "Patrijarha Varnave 20", "11000");
		locationRepository.save(location11);
		Location location12  = new Location(44.7992456, 20.4023128, "Beograd", "Vračar", "Makenzijeva 67", "11000");
		locationRepository.save(location12);
		Location location13  = new Location(44.7810466, 20.3820132, "Beograd", "Senjak", "Avgusta Cesarca", "11000");
		locationRepository.save(location13);
		Location location14  = new Location(44.79562, 20.4396247, "Beograd", "Vračar", "Beogradska 71", "11000");
		locationRepository.save(location14);
		Location location15  = new Location(44.7809182, 20.3820123, "Beograd", "Crveni krst", "Metohijska 11", "11000");
		locationRepository.save(location15);
		
		
		WorkingTime workingTime1 = new WorkingTime("09.00", "18.0", "Zatvoreno", "Zatvoreno");
		workingTimeRepository.save(workingTime1);
		
		Image image26 = new Image("company1", "a");
		imageRepository.save(image26);
		Image image27 = new Image("company2", "a");
		imageRepository.save(image27);
		Image image28 = new Image("company3", "a");
		imageRepository.save(image28);
		Image image29 = new Image("company4", "a");
		imageRepository.save(image29);
		Image image30 = new Image("user5", "a");
		imageRepository.save(image30);
		
		Set<Image> companyImages = new HashSet<Image>();
		companyImages.add(image26);
		companyImages.add(image27);
		Company company1 = new Company("001", "BEST REAL ESTATE", "company", "063-282-558", "www.bestrealestate.rs", location11, workingTime1);
		company1.setImages(companyImages);
		companyRepository.save(company1);
		Company company2 = new Company("002", "MENTOR REAL ESTATE BELGRADE", "company", "011-30-89-080", "m", location12, workingTime1);
		companyRepository.save(company2);
		Company company3 = new Company("003", "R.E.A.L. Consulting Nekretnine", "company", "069-46-68-118", "m", location13, workingTime1);
		companyRepository.save(company3);
		Company company4 = new Company("004", "Kvadrat nekretnine", "company", "011-33-48-871", "m", location14, workingTime1);
		companyRepository.save(company4);
		Company company5 = new Company("005", "FOX nekretnine", "company", "011-24-02-386", "foxnekretnine.com", location15, workingTime1);
		companyRepository.save(company5);

		
		Agent agent1 = new Agent(user1, company1);
		agentRepository.save(agent1);
		Agent agent2 = new Agent(user2, company1);
		agentRepository.save(agent2);
		Agent agent3 = new Agent(user3, company1);
		agentRepository.save(agent3);
		Agent agent4 = new Agent(user4, company2);
		agentRepository.save(agent4);
		Agent agent5 = new Agent(user5, company2);
		agentRepository.save(agent5);
		Agent agent6 = new Agent(user6, company2);
		agentRepository.save(agent6);
		Agent agent7 = new Agent(user7, company3);
		agentRepository.save(agent7);
		Agent agent8 = new Agent(user8, company3);
		agentRepository.save(agent8);
		Agent agent9 = new Agent(user9, company3);
		agentRepository.save(agent9);
		Agent agent10 = new Agent(user10, company4);
		agentRepository.save(agent10);

		
		IndoorFeature indoorFeature1 = new IndoorFeature("Floorboards");
		indoorFeatureRepository.save(indoorFeature1);
		IndoorFeature indoorFeature2 = new IndoorFeature("Built-in Wardrobes");
		indoorFeatureRepository.save(indoorFeature2);
		IndoorFeature indoorFeature3 = new IndoorFeature("Dishwasher");
		indoorFeatureRepository.save(indoorFeature3);
		IndoorFeature indoorFeature4 = new IndoorFeature("Air Conditioning");
		indoorFeatureRepository.save(indoorFeature4);
		IndoorFeature indoorFeature5 = new IndoorFeature("Intercom");
		indoorFeatureRepository.save(indoorFeature5);
		IndoorFeature indoorFeature6 = new IndoorFeature("Indoor Spa");
		indoorFeatureRepository.save(indoorFeature6);
		IndoorFeature indoorFeature7 = new IndoorFeature("Broadband Internet Available");
		indoorFeatureRepository.save(indoorFeature7);
		IndoorFeature indoorFeature8 = new IndoorFeature("Ducted Heating");
		indoorFeatureRepository.save(indoorFeature8);
		IndoorFeature indoorFeature9 = new IndoorFeature("Ducted Cooling");
		indoorFeatureRepository.save(indoorFeature9);
		IndoorFeature indoorFeature10 = new IndoorFeature("Rumpus Room");
		indoorFeatureRepository.save(indoorFeature10);
		IndoorFeature indoorFeature11 = new IndoorFeature("Alarm System");
		indoorFeatureRepository.save(indoorFeature11);
		IndoorFeature indoorFeature12 = new IndoorFeature("Ensuite");	
		indoorFeatureRepository.save(indoorFeature12);
		IndoorFeature indoorFeature13 = new IndoorFeature("Dusted vacum system");
		indoorFeatureRepository.save(indoorFeature13);
		IndoorFeature indoorFeature14 = new IndoorFeature("Open fireplace");
		indoorFeatureRepository.save(indoorFeature14);
		IndoorFeature indoorFeature15 = new IndoorFeature("a");
		indoorFeatureRepository.save(indoorFeature15);

	
		OutdoorFeature outdoorFeature1 = new OutdoorFeature("Secure Parking");
		outdoorFeatureRepository.save(outdoorFeature1);
		OutdoorFeature outdoorFeature2 = new OutdoorFeature("Courtyard");
		outdoorFeatureRepository.save(outdoorFeature2);
		OutdoorFeature outdoorFeature3 = new OutdoorFeature("Shed");
		outdoorFeatureRepository.save(outdoorFeature3);
		OutdoorFeature outdoorFeature4 = new OutdoorFeature("Deck");
		outdoorFeatureRepository.save(outdoorFeature4);
		OutdoorFeature outdoorFeature5 = new OutdoorFeature("Balcony");
		outdoorFeatureRepository.save(outdoorFeature5);
		OutdoorFeature outdoorFeature6 = new OutdoorFeature("Swimming Pool");
		outdoorFeatureRepository.save(outdoorFeature6);
		OutdoorFeature outdoorFeature7 = new OutdoorFeature("Carpot");
		outdoorFeatureRepository.save(outdoorFeature7);
		OutdoorFeature outdoorFeature8 = new OutdoorFeature("Garage");
		outdoorFeatureRepository.save(outdoorFeature8);
		OutdoorFeature outdoorFeature9 = new OutdoorFeature("Tenis court");
		outdoorFeatureRepository.save(outdoorFeature9);
		OutdoorFeature outdoorFeature10 = new OutdoorFeature("Outside spa");
		outdoorFeatureRepository.save(outdoorFeature10);

	
		HeatingType heatingType1 = new HeatingType("Forced Air");
		heatingTypeRepository.save(heatingType1);
		HeatingType heatingType2 = new HeatingType("Hydronic");
		heatingTypeRepository.save(heatingType2);
		HeatingType heatingType3 = new HeatingType("Geothermal");
		heatingTypeRepository.save(heatingType3);
		HeatingType heatingType4 = new HeatingType("Radiant Heat ");
		heatingTypeRepository.save(heatingType4);
		HeatingType heatingType5 = new HeatingType("Steam Radiant");
		heatingTypeRepository.save(heatingType5);

		
		RealEstateType realEstateType1 = new RealEstateType("APARTMENT");
		realEstateTypeRepository.save(realEstateType1);
		RealEstateType realEstateType2 = new RealEstateType("FLAT");
		realEstateTypeRepository.save(realEstateType2);
		RealEstateType realEstateType3 = new RealEstateType("HOUSE");
		realEstateTypeRepository.save(realEstateType3);
		RealEstateType realEstateType4 = new RealEstateType("PENTHOUSE");
		realEstateTypeRepository.save(realEstateType4);

		AdvertisementType advertisementType1 = new AdvertisementType("SALE");
		advertisementTypeRepository.save(advertisementType1);
		AdvertisementType advertisementType2 = new AdvertisementType("RENT");
		advertisementTypeRepository.save(advertisementType2);
		
		Image image1 = new Image("house1", "1");
		imageRepository.save(image1);
		Image image2 = new Image("house2", "1");
		imageRepository.save(image2);
		Image image3 = new Image("house3", "1");
		imageRepository.save(image3);
		Image image4 = new Image("house4", "1");
		imageRepository.save(image4);
		Image image5 = new Image("house5", "1");
		imageRepository.save(image5);
		Set<Image> images = new HashSet<Image>();
		images.add(image1);
		images.add(image2);
		images.add(image3);
		images.add(image4);
		images.add(image5);
		
		RealEstate realEstate1 = new RealEstate("naziv1..", "Lorem ipsum dolor sit amet, consectetur adipisicing elit.", 500.0, 50.0, 2, 1, 1, 2015, true, true, location1, realEstateType2, heatingType1, new Date(), new Date(), 48, false, false, agent1, advertisementType2);
		realEstate1.setImages(images);
		realEstateRepository.save(realEstate1);
		RealEstate realEstate2 = new RealEstate("naziv2..", "Lorem ipsum dolor sit amet, consectetur adipisicing elit.", 1500.0, 150.0, 2, 5, 2, 2015, true, true, location2, realEstateType3, heatingType1, new Date(), new Date(), 48, false, false, agent1, advertisementType2);
		realEstateRepository.save(realEstate2);
		RealEstate realEstate3 = new RealEstate("naziv3..", "Lorem ipsum dolor sit amet, consectetur adipisicing elit.", 5000.0, 300.0, 3, 7, 2, 2015, true, true, location3, realEstateType4, heatingType1, new Date(), new Date(), 48, false, false, agent1, advertisementType2);
		realEstateRepository.save(realEstate3);

		
		
		Image image6 = new Image("house6", "1", realEstate2);
		imageRepository.save(image6);
		Image image7 = new Image("house7", "1", realEstate2);
		imageRepository.save(image7);
		Image image8 = new Image("house8", "1", realEstate2);
		imageRepository.save(image8);
		Image image9 = new Image("house9", "1", realEstate2);
		imageRepository.save(image9);
		Image image10 = new Image("house10", "1", realEstate2);
		imageRepository.save(image10);

		
		Image image21 = new Image("house11", "1", realEstate3);
		imageRepository.save(image21);
		Image image22 = new Image("house12", "1", realEstate3);
		imageRepository.save(image22);
		Image image23 = new Image("house13", "1", realEstate3);
		imageRepository.save(image23);
		Image image24 = new Image("house14", "1", realEstate3);
		imageRepository.save(image24);
		Image image25 = new Image("house15", "1", realEstate3);
		imageRepository.save(image25);
		
	
		RealEstateIndoors realEstateIndoors = new RealEstateIndoors(realEstate1, indoorFeature1);
		realEstateIndoorsRepository.save(realEstateIndoors);
		RealEstateIndoors realEstateIndoors2 = new RealEstateIndoors(realEstate1, indoorFeature2);
		realEstateIndoorsRepository.save(realEstateIndoors2);
		
		
		RealEstateOutdoors realEstateOutdoors = new RealEstateOutdoors(realEstate2, outdoorFeature1);
		realEstateOutdoorsRepository.save(realEstateOutdoors);
		
		
		
		
		RealEstateComment realEstateComment1 = new RealEstateComment("comentarrr..", new Date(), realEstate1, user11);
		realEstateCommentRepository.save(realEstateComment1);
		RealEstateComment realEstateComment2 = new RealEstateComment(".comentarrr.", new Date(), realEstate1, user12);
		realEstateCommentRepository.save(realEstateComment2);
		RealEstateComment realEstateComment3 = new RealEstateComment(".comentarrr3.", new Date(), realEstate1, user13);
		realEstateCommentRepository.save(realEstateComment3);
		RealEstateComment realEstateComment4 = new RealEstateComment(".comentarrr2.", new Date(), realEstate1, user14);
		realEstateCommentRepository.save(realEstateComment4);
		RealEstateComment realEstateComment5 = new RealEstateComment("..", new Date(), realEstate1, user15);
		realEstateCommentRepository.save(realEstateComment5);
		RealEstateComment realEstateComment6 = new RealEstateComment("..aaaa", new Date(), realEstate2, user16);
		realEstateCommentRepository.save(realEstateComment6);
		RealEstateComment realEstateComment7 = new RealEstateComment(".aaaa.", new Date(), realEstate2, user16);
		realEstateCommentRepository.save(realEstateComment7);
		RealEstateComment realEstateComment8 = new RealEstateComment("aa..", new Date(), realEstate2, user18);
		realEstateCommentRepository.save(realEstateComment8);
		RealEstateComment realEstateComment9 = new RealEstateComment("..", new Date(), realEstate3, user18);
		realEstateCommentRepository.save(realEstateComment9);
		RealEstateComment realEstateComment10 = new RealEstateComment("..", new Date(), realEstate3, user19);
		realEstateCommentRepository.save(realEstateComment10);

		
		RealEstateRating realEstateRating1 = new RealEstateRating(5, new Date(), realEstate1, user11);
		realEstateRatingRepository.save(realEstateRating1);
		RealEstateRating realEstateRating2 = new RealEstateRating(5, new Date(), realEstate1, user12);
		realEstateRatingRepository.save(realEstateRating2);
		RealEstateRating realEstateRating3 = new RealEstateRating(4, new Date(), realEstate1, user13);
		realEstateRatingRepository.save(realEstateRating3);
		RealEstateRating realEstateRating4 = new RealEstateRating(4, new Date(), realEstate1, user14);
		realEstateRatingRepository.save(realEstateRating4);
		RealEstateRating realEstateRating5 = new RealEstateRating(3, new Date(), realEstate1, user15);
		realEstateRatingRepository.save(realEstateRating5);
		RealEstateRating realEstateRating6 = new RealEstateRating(1, new Date(), realEstate1, user16);
		realEstateRatingRepository.save(realEstateRating6);
		RealEstateRating realEstateRating7 = new RealEstateRating(3, new Date(), realEstate2, user11);
		realEstateRatingRepository.save(realEstateRating7);
		RealEstateRating realEstateRating8 = new RealEstateRating(1, new Date(), realEstate2, user12);
		realEstateRatingRepository.save(realEstateRating8);
		RealEstateRating realEstateRating9 = new RealEstateRating(2, new Date(), realEstate2, user13);
		realEstateRatingRepository.save(realEstateRating9);
		RealEstateRating realEstateRating10 = new RealEstateRating(1, new Date(), realEstate2, user14);
		realEstateRatingRepository.save(realEstateRating10);
		RealEstateRating realEstateRating11 = new RealEstateRating(2, new Date(), realEstate2, user15);
		realEstateRatingRepository.save(realEstateRating11);
		RealEstateRating realEstateRating12 = new RealEstateRating(3, new Date(), realEstate2, user16);
		realEstateRatingRepository.save(realEstateRating12);
		RealEstateRating realEstateRating13 = new RealEstateRating(5, new Date(), realEstate3, user11);
		realEstateRatingRepository.save(realEstateRating13);
		RealEstateRating realEstateRating14 = new RealEstateRating(4, new Date(), realEstate3, user12);
		realEstateRatingRepository.save(realEstateRating14);
		RealEstateRating realEstateRating15 = new RealEstateRating(5, new Date(), realEstate3, user13);
		realEstateRatingRepository.save(realEstateRating15);

		
		RealEstateReport realEstateReport1 = new RealEstateReport("..", new Date(), realEstate2, user17);
		realEstateReportRepository.save(realEstateReport1);
		RealEstateReport realEstateReport2 = new RealEstateReport("..", new Date(), realEstate2, user18);
		realEstateReportRepository.save(realEstateReport2);
		RealEstateReport realEstateReport3 = new RealEstateReport("..", new Date(), realEstate2, user19);
		realEstateReportRepository.save(realEstateReport3);
		RealEstateReport realEstateReport4 = new RealEstateReport("..", new Date(), realEstate2, user20);
		realEstateReportRepository.save(realEstateReport4);
		RealEstateReport realEstateReport5 = new RealEstateReport("..", new Date(), realEstate2, user18);
		realEstateReportRepository.save(realEstateReport5);
		RealEstateReport realEstateReport6 = new RealEstateReport("..", new Date(), realEstate3, user19);
		realEstateReportRepository.save(realEstateReport6);
		RealEstateReport realEstateReport7 = new RealEstateReport("..", new Date(), realEstate3, user20);
		realEstateReportRepository.save(realEstateReport7);

		
		AgentRating agentRating1 = new AgentRating(5, new Date(), agent1, user11);
		agentRatingRepository.save(agentRating1);
		AgentRating agentRating2 = new AgentRating(5, new Date(), agent1,  user12);
		agentRatingRepository.save(agentRating2);
		AgentRating agentRating3 = new AgentRating(4, new Date(), agent1, user13);
		agentRatingRepository.save(agentRating3);
		AgentRating agentRating4 = new AgentRating(3, new Date(), agent1, user14);
		agentRatingRepository.save(agentRating4);
		AgentRating agentRating5 = new AgentRating(3, new Date(), agent1, user15);
		agentRatingRepository.save(agentRating5);
		AgentRating agentRating6 = new AgentRating(3, new Date(), agent1, user16);
		agentRatingRepository.save(agentRating6);
		AgentRating agentRating7 = new AgentRating(5, new Date(), agent1, user17);
		agentRatingRepository.save(agentRating7);
		AgentRating agentRating8 = new AgentRating(4, new Date(), agent1, user18);
		agentRatingRepository.save(agentRating8);
		AgentRating agentRating9 = new AgentRating(1, new Date(), agent1, user19);
		agentRatingRepository.save(agentRating9);
		AgentRating agentRating10 = new AgentRating(1, new Date(), agent2, user20);
		agentRatingRepository.save(agentRating10);
		AgentRating agentRating11 = new AgentRating(1, new Date(), agent2, user11);
		agentRatingRepository.save(agentRating11);
		AgentRating agentRating12 = new AgentRating(2, new Date(), agent2, user12);
		agentRatingRepository.save(agentRating12);
		AgentRating agentRating13 = new AgentRating(2, new Date(), agent2, user13);
		agentRatingRepository.save(agentRating13);
		AgentRating agentRating14 = new AgentRating(3, new Date(), agent2, user14);
		agentRatingRepository.save(agentRating14);
		AgentRating agentRating15 = new AgentRating(3, new Date(), agent2, user15);
		agentRatingRepository.save(agentRating15);
		

		
	}
	
}
