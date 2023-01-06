package observers;

import subject.ABCCompany;

import java.util.Scanner;

public class RegularUser extends Observer {
    public enum RegularUserState {
        FULLY_ABC,
        PARTIALLY_ABC,
        FULLY_DEF,
        NO_SERVICE
    }

    private RegularUserState regularState;

    public RegularUser(ABCCompany server, String userName) {
        super(server, userName);
        this.regularState = RegularUserState.FULLY_ABC;
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
                
            } else if (currentState == ABCCompany.State.FULLY_DOWN) {

            }
        } else if (previousState == ABCCompany.State.PARTIALLY_DOWN) {
            if (currentState == ABCCompany.State.OPERATIONAL) {

            } else if (currentState == ABCCompany.State.FULLY_DOWN) {

            }
        } else if (previousState == ABCCompany.State.FULLY_DOWN) {
            if (currentState == ABCCompany.State.OPERATIONAL) {

            } else if (currentState == ABCCompany.State.PARTIALLY_DOWN) {

            }
        }
    }

    @Override
    protected void showState() {

    }
}
