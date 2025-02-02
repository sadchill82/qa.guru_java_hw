package lesson7.utils;

import net.datafaker.Faker;

public class RandomUtils {

    private static final Faker FAKER = new Faker();

    private static final String[] MONTHS = {
            "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
    };
    private static final String[] SUBJECTS = {
            "Hindi", "English", "Maths", "Physics", "Chemistry", "Biology",
            "Computer Science", "Commerce", "Accounting", "Economics",
            "Arts", "Social Studies", "History", "Civics"
    };
    private static final String[] HOBBIES = {"Sports", "Reading", "Music"};
    private static final String[] PICTURES = {"picture1.jpg", "picture2.jpg"};
    private static final String[] STATES = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};

    public final String firstName = FAKER.name().firstName();
    public final String lastName = FAKER.name().lastName();
    public final String email = FAKER.internet().emailAddress();
    public final String gender = FAKER.gender().binaryTypes();
    public final String number = FAKER.numerify("##########");
    public final String day = String.valueOf(FAKER.number().numberBetween(01, 28));
    public final String month = FAKER.options().option(MONTHS);
    public final String year = String.valueOf(FAKER.number().numberBetween(1920, 2024));
    public final String subject = FAKER.options().option(SUBJECTS);
    public final String hobbies = FAKER.options().option(HOBBIES);
    public final String picture = FAKER.options().option(PICTURES);
    public final String currentAddress = FAKER.address().fullAddress();
    public final String state = FAKER.options().option(STATES);
    public final String city = selectCity(state);

    private String selectCity(String state) {
        return switch (state) {
            case "NCR" -> FAKER.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh" -> FAKER.options().option("Agra", "Lucknow", "Merrut");
            case "Haryana" -> FAKER.options().option("Karnal", "Panipat");
            case "Rajasthan" -> FAKER.options().option("Jaipur", "Jaiselmer");
            default -> "";
        };
    }
}