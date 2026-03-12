import java.util.*;

public class SheShieldSystem {

    static Scanner sc = new Scanner(System.in);

    // CO4: HashMap (Emergency Contacts)
    static HashMap<Integer,String> emergencyContacts = new HashMap<>();

    // CO3: Stack (SOS Alert History)
    static Stack<String> sosHistory = new Stack<>();

    // CO3: Queue (Safety News Updates)
    static Queue<String> newsQueue = new LinkedList<>();

    // CO2: Array (Mood Storage)
    static String moodArray[] = new String[50];
    static int moodCount = 0;

    // CO2: Linked List (Safety Tips Storage)
    static LinkedList<String> safetyTipsList = new LinkedList<>();

    static boolean loggedIn = false;

    public static void main(String[] args) {

        // Insert emergency contacts into HashMap
        emergencyContacts.put(1,"Police : 112");
        emergencyContacts.put(2,"Ambulance : 108");
        emergencyContacts.put(3,"Women Helpline : 181");

        // Enqueue safety news updates into Queue
        newsQueue.add("New Self Defense Programs for Women");
        newsQueue.add("Government launches Women Safety App");
        newsQueue.add("Helpline services expanded across India");

        // Insert safety tips into Linked List
        safetyTipsList.add("Share location with trusted contacts");
        safetyTipsList.add("Avoid isolated areas at night");
        safetyTipsList.add("Keep emergency numbers saved");

        login();

        while(loggedIn){

            System.out.println("\n====== Women Safety Awareness And Support ======");
            System.out.println("1. SOS Panic");
            System.out.println("2. Emergency Contacts");
            System.out.println("3. Safe Places Nearby");
            System.out.println("4. Voice SOS");
            System.out.println("5. Safety News");
            System.out.println("6. Know Your Rights");
            System.out.println("7. Safety Tips");
            System.out.println("8. Track Mood");
            System.out.println("9. View Mood History");
            System.out.println("10. View SOS History");
            System.out.println("11. Search Mood");
            System.out.println("12. Logout");

            System.out.print("Choose option: ");
            int choice = sc.nextInt();

            switch(choice){

                case 1:
                    activateSOS();
                    break;

                case 2:
                    showEmergency();
                    break;

                case 3:
                    findSafePlaces();
                    break;

                case 4:
                    voiceSOS();
                    break;

                case 5:
                    showNews();
                    break;

                case 6:
                    showRights();
                    break;

                case 7:
                    showSafetyTips();
                    break;

                case 8:
                    trackMood();
                    break;

                case 9:
                    showMoodHistory();
                    break;

                case 10:
                    showSOSHistory();
                    break;

                case 11:
                    searchMood();
                    break;

                case 12:
                    logout();
                    break;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    // LOGIN MODULE
    static void login(){

        System.out.println("===== Women Safety Login =====");

        System.out.print("Enter Username: ");
        String user = sc.next();

        System.out.print("Enter Password: ");
        String pass = sc.next();

        if(!user.isEmpty() && !pass.isEmpty()){
            loggedIn = true;
            System.out.println("Login Successful!");
        } else {
            System.out.println("Login Failed");
        }
    }

    // LOGOUT MODULE
    static void logout(){
        loggedIn = false;
        System.out.println("Logged Out Successfully");
    }

    // CO3: STACK IMPLEMENTATION
    // Stores SOS alerts using push operation
    static void activateSOS(){

        System.out.println("SOS Activated!");
        System.out.println("Sending your location to emergency contacts...");

        String time = new Date().toString();
        sosHistory.push(time);

        System.out.println("SOS Recorded at: " + time);
    }

    // CO4: HASHMAP IMPLEMENTATION
    // Retrieves emergency contacts using key-value mapping
   static void showEmergency(){

    System.out.println("\nEmergency Contacts:");

    for(int key : emergencyContacts.keySet()){
        System.out.println(key + ". " + emergencyContacts.get(key));
    }

    System.out.print("\nEnter contact number to view: ");
    int choice = sc.nextInt();

    if(emergencyContacts.containsKey(choice)){
        System.out.println("Calling: " + emergencyContacts.get(choice));
    }
    else{
        System.out.println("Invalid contact.");
    }
}
    static void findSafePlaces(){

        System.out.println("\nSafe Places Nearby:");
        System.out.println("1. Police Station");
        System.out.println("2. Hospital");
        System.out.println("3. Women's Help Center");
    }

    static void voiceSOS(){

        sc.nextLine();

        System.out.print("Speak Command: ");
        String command = sc.nextLine().toLowerCase();

        if(command.contains("help") || command.contains("sos")){
            activateSOS();
        } else {
            System.out.println("Command not recognized");
        }
    }

    // CO1: LINEAR SEARCH IMPLEMENTATION
    static void searchMood(){

        sc.nextLine();

        System.out.print("Enter mood to search: ");
        String target = sc.nextLine();

        boolean found = false;

        for(int i = 0; i < moodCount; i++){

            if(moodArray[i].equalsIgnoreCase(target)){
                found = true;
                break;
            }
        }

        if(found){
            System.out.println("Mood found in history.");
        } else {
            System.out.println("Mood not found.");
        }
    }

    // CO3: QUEUE IMPLEMENTATION
    static void showNews(){

        System.out.println("\nWomen Safety News:");

        for(String news : newsQueue){
            System.out.println("- " + news);
        }
    }

    static void showRights(){

        System.out.println("\nKnow Your Rights:");

        System.out.println("1. Right to Self Defense");
        System.out.println("2. Right to File FIR");
        System.out.println("3. Right to Free Legal Aid");
    }

    // CO2: LINKED LIST IMPLEMENTATION
    static void showSafetyTips(){

        System.out.println("\nSafety Tips:");

        for(String tip : safetyTipsList){
            System.out.println("- " + tip);
        }
    }

    // CO2: ARRAY IMPLEMENTATION
    static void trackMood(){

        System.out.println("\nSelect Mood");
        System.out.println("1. Happy");
        System.out.println("2. Calm");
        System.out.println("3. Stressed");
        System.out.println("4. Strong");

        int m = sc.nextInt();

        String mood="";

        switch(m){

            case 1: mood="Happy"; break;
            case 2: mood="Calm"; break;
            case 3: mood="Stressed"; break;
            case 4: mood="Strong"; break;

            default:
                System.out.println("Invalid Mood");
                return;
        }

        moodArray[moodCount++] = mood;

        System.out.println("Mood Saved!");
    }

    // ARRAY TRAVERSAL
    static void showMoodHistory(){

        System.out.println("\nMood History:");

        if(moodCount == 0){
            System.out.println("No moods recorded yet.");
            return;
        }

        for(int i = 0; i < moodCount; i++){
            System.out.println(moodArray[i]);
        }
    }

    // STACK TRAVERSAL (LIFO)
    static void showSOSHistory(){

        System.out.println("\nSOS Alert History:");

        if(sosHistory.isEmpty()){
            System.out.println("No SOS alerts recorded.");
            return;
        }

        for(int i = sosHistory.size() - 1; i >= 0; i--){
            System.out.println(sosHistory.get(i));
        }
    }
}