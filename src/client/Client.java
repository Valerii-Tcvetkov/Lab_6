package client;

public class Client {
    private String name;
    private String surname;
    private String address;
    private int passport;

    private Client() {
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getAddress() {
        return address;
    }

    public int getPassport() {
        return passport;
    }

    public static Builder newBuilder() {
        return new Client().new Builder();
    }

    public class Builder {

        private Builder() {

        }

        public Builder setName(String name) {
            Client.this.name = name;
            return this;
        }

        public Builder setSurname(String surname) {
            Client.this.surname = surname;
            return this;
        }

        public Builder setAddress(String address) {
            Client.this.address = address;
            return this;
        }

        public Builder setPassport(int passport) {
            Client.this.passport = passport;
            return this;
        }

        public Client build() {
            return Client.this;
        }

    }
}
