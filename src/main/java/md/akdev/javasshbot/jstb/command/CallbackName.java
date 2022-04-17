package md.akdev.javasshbot.jstb.command;

public enum CallbackName {
    ASSET("asset"),
    COMMAND("command");

    private final String callbackName;

    CallbackName(String callbackName) {this.callbackName = callbackName;}

    public String getCallbackName() {return this.callbackName;}

}
