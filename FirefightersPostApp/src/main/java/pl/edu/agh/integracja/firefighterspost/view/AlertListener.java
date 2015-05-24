package pl.edu.agh.integracja.firefighterspost.view;

public interface AlertListener<T> {

    void onAlertReceive(T message);
}
