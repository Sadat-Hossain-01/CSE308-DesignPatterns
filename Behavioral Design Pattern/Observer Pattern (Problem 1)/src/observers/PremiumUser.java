package observers;

import subject.ABCCompany;

public class PremiumUser extends Observer {
    private boolean twoServer;

    public PremiumUser(ABCCompany server, String userName) {
        super(server, userName);
        twoServer = false;
    }

    @Override
    public void notifyObserver() {
        ABCCompany.State currentState = server.getCurrentState();
        ABCCompany.State previousState = server.getPreviousState();

        showReceivingMessage(currentState.toString());

        int choice = 0;
        boolean inputOn = true;

        if (previousState == ABCCompany.State.OPERATIONAL) {
            if (currentState == ABCCompany.State.PARTIALLY_DOWN) {
                // ask if the user wants to use two servers or from one (DEF)
                while (inputOn) {
                    System.out.println("The system is partially down. Which option do you want to choose?");
                    System.out.println("1. Use two servers (partially ABC, partially DEF)");
                    System.out.println("2. Use one server (DEF)");
                    choice = takeIntInput(1, 2);
                    if (choice != -1) {
                        inputOn = false;
                    }
                }

                if (choice == 1) {
                    twoServer = true;
                    System.out.println("Getting served by both ABC and DEF company");
                } else {
                    twoServer = false;
                    System.out.println("Full service being given by DEF company");
                }

            } else if (currentState == ABCCompany.State.FULLY_DOWN) {
                // full service will be provided by DEF company now
                twoServer = false;
                System.out.println("Full service being given by DEF company");
            }
        } else if (previousState == ABCCompany.State.PARTIALLY_DOWN) {
            if (currentState == ABCCompany.State.OPERATIONAL) {
                // nothing will happen
                System.out.println("No change in status");
            } else if (currentState == ABCCompany.State.FULLY_DOWN) {
                // if user was using both servers, shift all to DEF. otherwise keep same
                if (twoServer) {
                    twoServer = false;
                    System.out.println("All service got shifted to DEF company");
                } else {
                    System.out.println("No change in status");
                }
            }
        } else if (previousState == ABCCompany.State.FULLY_DOWN) {
            if (currentState == ABCCompany.State.OPERATIONAL) {
                // nothing will happen
                System.out.println("No change in status");
            } else if (currentState == ABCCompany.State.PARTIALLY_DOWN) {
                // nothing will happen
                System.out.println("No change in status");
            }
        }

        System.out.print("\n");
    }

    @Override
    public String toString() {
        return userName + "(Premium User)";
    }
}
