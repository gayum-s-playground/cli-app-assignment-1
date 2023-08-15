import java.util.Arrays;
import java.util.Scanner;
public class CliBankingApp{
    private static final Scanner SCANNER = new Scanner(System.in);
    public static void main(String[] args) {

        
        final String CLEAR = "\033[H\033[2J";
        final String COLOR_BLUE_BOLD = "\033[34;1m";
        final String COLOR_RED_BOLD = "\033[31;1m";
        final String COLOR_GREEN_BOLD = "\033[33;1m";
        final String RESET = "\033[0m";

        final String DASHBOARD = " Welcome to Smart Banking App";
        final String CREATE_NEW_ACCOUNT = " Create New Account";
        final String DEPOSITE = " Deposite";
        final String WITHDRAWALS = " Withdrawals";
        final String TRANSFER = " Transfer";
        final String CHECK_ACCOUNT_BALANCE = " Check Account Balance";
        final String DELETE_ACCOUNT = " Delete Account";

        final String ERROR_MSG = String.format("\t%s%s%s\n", COLOR_RED_BOLD, "%s", RESET);
        final String SUCCESS_MSG = String.format("\t%s%s%s\n", COLOR_GREEN_BOLD, "%s", RESET);

        String screen = DASHBOARD;

        int[] userIds = new int[0];
        String[] userName = new String[0];

        
        do{
            final String APP_TITLE = String.format("%s%s%s",COLOR_BLUE_BOLD, screen, RESET);

            System.out.println(CLEAR);
            System.out.println("\t\t" + APP_TITLE + "\n");

            
            switch(screen){
                case DASHBOARD: 

                    System.out.println("\t[1]. Create New Account");
                    System.out.println("\t[2]. Deposite");
                    System.out.println("\t[3]. Withdrawals");
                    System.out.println("\t[4]. Transfer");
                    System.out.println("\t[5]. Check Account Balance");
                    System.out.println("\t[6]. Delete Account");
                    System.out.println("\t[7]. Exit\n");
                    System.out.print("\tEnter an option to continue: ");
                    int option = SCANNER.nextInt();
                    SCANNER.nextLine();
                    
                    switch (option){
                        case 1: screen = CREATE_NEW_ACCOUNT; break;
                        case 2: screen = DEPOSITE; break;
                        case 3: screen = WITHDRAWALS; break;
                        case 4: screen = TRANSFER; break;
                        case 5: screen = CHECK_ACCOUNT_BALANCE; break;
                        case 6: screen = DELETE_ACCOUNT; break;
                        case 7: System.out.println(CLEAR); System.exit(0);
                        default: continue;
                    }
                    break ; 

                case CREATE_NEW_ACCOUNT:
                    
                    System.out.printf("\tNew Student ID: SDB-%04d \n", (userIds.length + 1));

                    boolean valid;
                    String name;
                    //Name validation
                    do{
                        valid = true;
                        System.out.print("\tEnter User Name: ");
                        name = SCANNER.nextLine().strip();
                        if (name.isBlank()){
                            System.out.printf("\t%sName can't be empty%s\n", COLOR_RED_BOLD, RESET);
                            valid = false;
                            continue;
                        }
                        for (int i = 0; i < name.length(); i++) {
                            if (!(Character.isLetter(name.charAt(i)) || Character.isSpaceChar(name.charAt(i))) ) {
                                System.out.printf("\t%sInvalid Name%s\n", COLOR_RED_BOLD, RESET);
                                valid = false;
                                break;
                            }
                        }
                    }while(!valid);

                    int[] newIdArray = new int[userIds.length + 1];
                    String[] newNameArray = new String[newIdArray.length];
                    int index=1;
                    for (int i = 0; i < userIds.length; i++) {
                        newIdArray[i] = userIds[i];
                        index++;
                    }
                    newIdArray[newIdArray.length -1] = index;
                    userIds = newIdArray;

                    for (int i = 0; i < userName.length; i++) {
                        newNameArray[i] = userName[i];
                    }
                    newNameArray[newNameArray.length -1] = name;
                    userName = newNameArray;

                    System.out.println(Arrays.toString(userName));
                    System.out.println(Arrays.toString(userIds));

            }       
                
        }while(true);

    }
}