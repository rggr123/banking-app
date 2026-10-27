package kodevo.banking_app.dto;

public record LoginRequest(String username, String password) {

    public Object getPassword() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
