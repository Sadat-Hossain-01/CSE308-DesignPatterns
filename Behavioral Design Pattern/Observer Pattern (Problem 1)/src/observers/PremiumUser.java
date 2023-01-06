package observers;

import subject.ABCCompany;

import java.util.Scanner;

public class PremiumUser extends Observer {
    public enum PremiumUserState {
        FULLY_ABC,
        ABC_DEF,
        FULLY_DEF
    }

    private PremiumUserState premiumState;

    public PremiumUser(ABCCompany server, String userName) {
        super(server, userName);
        this.premiumState = PremiumUserState.FULLY_ABC;
    }

    @Override
    public void notifyObserver() {
        ABCCompany.State currentState = server.getCurrentState();
        ABCCompany.State previousState = server.getPreviousState();

        System.out.println(userName + " (Premium User): got notified");

        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        boolean inputOn = true;

        if (previousState == ABCCompany.State.OPERATIONAL) {
            if (currentState == ABCCompany.State.PARTIALLY_DOWN) {
                // ask if the user wants to use two servers or from one (DEF)
                System.out.println("The system is partially down. Which option do you want to use?");
                System.out.println("1. Use two servers (partially ABC, partially DEF)");
                System.out.println("2. Use one server (DEF)");

                while (inputOn) {
                    try {
                        choice = scanner.nextInt();
                        if (choice == 1 || choice == 2) {
                            inputOn = false;
                        } else {
                            throw new Exception();
                        }
                    } catch (Exception e) {
                        System.out.println("Please enter a valid choice.");
                        continue;
                    }
                }

                if (choice == 1) {
                    this.premiumState = PremiumUserState.ABC_DEF;
                } else {
                    this.premiumState = PremiumUserState.FULLY_DEF;
                }

            } else if (currentState == ABCCompany.State.FULLY_DOWN) {
                // full service will be provided by DEF company now
                this.premiumState = PremiumUserState.FULLY_DEF;
            }
        } else if (previousState == ABCCompany.State.PARTIALLY_DOWN) {
            if (currentState == ABCCompany.State.OPERATIONAL) {
                // nothing will happen
            } else if (currentState == ABCCompany.State.FULLY_DOWN) {
                // if user was using both servers, shift all to DEF. otherwise keep same
                if (premiumState == PremiumUserState.ABC_DEF) {
                    premiumState = PremiumUserState.FULLY_DEF;
                }
            }
        } else if (previousState == ABCCompany.State.FULLY_DOWN) {
            if (currentState == ABCCompany.State.OPERATIONAL) {
                // nothing will happen
            } else if (currentState == ABCCompany.State.PARTIALLY_DOWN) {
                // nothing will happen
            }
        }

        showState();

        scanner.close();
    }

    @Override
    protected void showState() {
        if (premiumState == PremiumUserState.FULLY_ABC) {
            System.out.println(userName + " (Premium User): using ABC server completely");
        }
        else if (premiumState == PremiumUserState.ABC_DEF) {
            System.out.println(userName + " (Premium User): using partially from both ABC and DEF servers");
        }
        else if (premiumState == PremiumUserState.FULLY_DEF) {
            System.out.println(userName + " (Premium User): using DEF server completely");
        }
    }

}
