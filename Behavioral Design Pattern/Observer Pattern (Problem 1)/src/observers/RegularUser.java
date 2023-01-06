package observers;

import subject.ABCCompany;

import java.util.Random;
import java.util.Scanner;

public class RegularUser extends Observer {
    public enum RegularUserState {
        FULLY_ABC,
        PARTIALLY_ABC,
        FULLY_DEF, // most probably this means full service using both, but anyways this is the name
        NO_SERVICE
    }

    private RegularUserState regularState;

    public RegularUser(ABCCompany server, String userName) {
        super(server, userName);
        this.regularState = RegularUserState.FULLY_ABC;
    }

    private void sendBill(int l, int r) {
        Random random = new Random();
        int bill = random.nextInt(r - l + 1) + l;
        System.out.println("Total bill: $" + bill);
    }

    @Override
    public void notifyObserver() {
        ABCCompany.State currentState = server.getCurrentState();
        ABCCompany.State previousState = server.getPreviousState();

        System.out.println(userName + " (Regular User): got notified");

        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        boolean inputOn = true;

        if (previousState == ABCCompany.State.OPERATIONAL) {
            if (currentState == ABCCompany.State.PARTIALLY_DOWN) {
                // ask if user wants to continue with limited functionality or pay $20/hour to use DEF as well
                while (inputOn) {
                    System.out.println("The system is partially down. Which option do you want to choose?");
                    System.out.println("1. Continue with limited functionality");
                    System.out.println("2. Pay $20/hour to enjoy full functionality taking service from DEF server");
                    choice = takeInput(1, 2);
                    if (choice != -1) {
                        inputOn = false;
                    }
                }

                if (choice == 1) {
                    regularState = RegularUserState.PARTIALLY_ABC;
                } else if (choice == 2) {
                    regularState = RegularUserState.FULLY_DEF;
                }

            } else if (currentState == ABCCompany.State.FULLY_DOWN) {
                // ask if the user wants to pay to shift to DEF
                while (inputOn) {
                    System.out.println("The system is fully down. Do you want to pay $20/hour to take service from DEF company?");
                    System.out.println("1. Yes");
                    System.out.println("2. No");
                    choice = takeInput(1, 2);
                    if (choice != -1) {
                        inputOn = false;
                    }
                }

                if (choice == 1) {
                    regularState = RegularUserState.FULLY_DEF;
                } else if (choice == 2) {
                    regularState = RegularUserState.NO_SERVICE;
                }
            }
        } else if (previousState == ABCCompany.State.PARTIALLY_DOWN) {
            if (currentState == ABCCompany.State.OPERATIONAL) {
                // if user was paying, send him/her a bill
                if (regularState == RegularUserState.FULLY_DEF) {
                    sendBill(100, 1000);
                    //take him back to ABC
                    regularState = RegularUserState.FULLY_ABC;
                }

            } else if (currentState == ABCCompany.State.FULLY_DOWN) {
                // do nothing
            }
        } else if (previousState == ABCCompany.State.FULLY_DOWN) {
            if (currentState == ABCCompany.State.OPERATIONAL) {
                sendBill(100, 1000);
            } else if (currentState == ABCCompany.State.PARTIALLY_DOWN) {
                // do nothing
            }
        }

        showState();
    }

    @Override
    protected void showState() {
        if (regularState == RegularUserState.FULLY_ABC) {

        } else if (regularState == RegularUserState.PARTIALLY_ABC) {

        } else if (regularState == RegularUserState.FULLY_DEF) {

        } else if (regularState == RegularUserState.NO_SERVICE) {

        }
    }
}
