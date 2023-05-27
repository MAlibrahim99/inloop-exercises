public class GarageDoor {

    private DoorState currentState;
    private Motor myMotor;
    public GarageDoor() {
        this.currentState = new Closed();
        this.myMotor = new Motor();
    }

    public void openDoor() {
        currentState.openDoor();
    }

    public void closeDoor() {
        currentState.closeDoor();
    }

    public void stopper() {
        currentState.stopper();
        }



    private abstract class DoorState {
        public void openDoor() {
            throw new IllegalStateException();

        }

        public void closeDoor() {
            throw new IllegalStateException();

        }

        public void stopper() {
            throw new IllegalStateException();
        }
    }

    private class Closed extends DoorState{
        @Override
        public void openDoor(){
            myMotor.upwards();
            currentState = new Opening();
        }

    }

    private class Open extends DoorState{
        @Override
        public void closeDoor(){
            myMotor.downwards();
            currentState = new Closing();
        }

    }

    private class Opening extends DoorState{
        @Override
        public void closeDoor(){
            myMotor.downwards();
            currentState = new Closing();
        }

        @Override
        public void stopper(){
            myMotor.stop();
            currentState = new Open();
        }
    }

    private class Closing extends DoorState{
        @Override
        public void stopper(){
            myMotor.stop();
            currentState = new Closed();
        }

        @Override
        public void openDoor(){
            myMotor.stop();
            myMotor.upwards();
            currentState = new Opening();
        }

    }

    private class Motor{

        public void upwards(){}

        public void downwards(){}

        public void stop(){}

    }





}