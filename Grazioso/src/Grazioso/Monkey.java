package Grazioso;

public class Monkey extends RescueAnimal {

	// Instance variables (all strings to follow convention from RescueAnimal class)
	private String tailLength;
	private String height;
	private String bodyLength;
	private String species;

	// Monkey constructor initializing to default values
	public Monkey() {
		setName("None");
		setGender("None");
		setAge("None");
		setWeight("None");
		setAcquisitionDate("None");
		setAcquisitionLocation("None");
		setTrainingStatus("None");
		setReserved(false);
		setInServiceCountry("None");
		setTailLength("None");
		setHeight("None");
		setBodyLength("None");
		setSpecies("None");
	}

	// Monkey constructor including all parameters
	public Monkey(String name, String gender, String age, String weight, String acquisitionDate,
			String acquisitionCountry, String trainingStatus, boolean reserved, String inServiceCountry,
			String tailLength, String height, String bodyLength, String species) {
		setName(name);
		setGender(gender);
		setAge(age);
		setWeight(weight);
		setAcquisitionDate(acquisitionDate);
		setAcquisitionLocation(acquisitionCountry);
		setTrainingStatus(trainingStatus);
		setReserved(reserved);
		setInServiceCountry(inServiceCountry);
		setTailLength(tailLength);
		setHeight(height);
		setBodyLength(bodyLength);
		setSpecies(species);
	}

	// Setters and getters
	public String getTailLength() {
		return tailLength;
	}

	public void setTailLength(String tailLength) {
		this.tailLength = tailLength;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getBodyLength() {
		return bodyLength;
	}

	public void setBodyLength(String bodyLength) {
		this.bodyLength = bodyLength;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

}
