package com.joedayz.model;

public class Phone {
	private int id;
	private String manufacturer;
	private String brand;
	private String model;
	private String release;
	private String os;
	private String osVersion;
	private String processor;
	private String memory;
	private String storage;
	private String weight;
	private String dateCreate;
	private String userCreate;
	
	public Phone() {
		// TODO Auto-generated constructor stub
	}
	
	public Phone(String brand,String model) {
		// TODO Auto-generated constructor stub
		this.brand=brand;
		this.model=model;
	}

	public String getDateCreate() {
		return dateCreate;
	}
	public void setDateCreate(String dateCreate) {
		this.dateCreate = dateCreate;
	}
	public String getUserCreate() {
		return userCreate;
	}
	public void setUserCreate(String userCreate) {
		this.userCreate = userCreate;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getRelease() {
		return release;
	}
	public void setRelease(String release) {
		this.release = release;
	}
	public String getOs() {
		return os;
	}
	public void setOs(String os) {
		this.os = os;
	}
	public String getOsVersion() {
		return osVersion;
	}
	public void setOsVersion(String osVersion) {
		this.osVersion = osVersion;
	}
	public String getProcessor() {
		return processor;
	}
	public void setProcessor(String processor) {
		this.processor = processor;
	}
	public String getMemory() {
		return memory;
	}
	public void setMemory(String memory) {
		this.memory = memory;
	}
	public String getStorage() {
		return storage;
	}
	public void setStorage(String storage) {
		this.storage = storage;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Phone [id=");
		builder.append(id);
		builder.append(", manufacturer=");
		builder.append(manufacturer);
		builder.append(", brand=");
		builder.append(brand);
		builder.append(", model=");
		builder.append(model);
		builder.append(", release=");
		builder.append(release);
		builder.append(", os=");
		builder.append(os);
		builder.append(", osVersion=");
		builder.append(osVersion);
		builder.append(", processor=");
		builder.append(processor);
		builder.append(", memory=");
		builder.append(memory);
		builder.append(", storage=");
		builder.append(storage);
		builder.append(", weight=");
		builder.append(weight);
		builder.append("]");
		return builder.toString();
	}
}
