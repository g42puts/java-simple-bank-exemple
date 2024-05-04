package org.example;

public class User {
    private String name;
    private String lastName;
    private String cpf;

    public User(String name, String lastName, String cpf) {
        this.name = name;
        this.lastName = lastName;
        this.cpf = cpf;
    }

    public String getName() {
        return this.name;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getCpf() {
        return this.cpf;
    }

    public String getFullName() {
        return String.format("%s %s", name, lastName);
    }

    public void setName(String name) {
        String firstName = this.name;

        if (firstName.equals(name)) {
            System.out.println("Os nomes não foram trocados pois são iguais.");
            return;
        }

        this._setName(name);
    }

    public void setLastName(String name) {
        String lastName = this.name;

        if (lastName.equals(name)) {
            System.out.println("Os sobrenomes não foram trocados pois são iguais.");
            return;
        }

        this._setLastName(name);
    }

    private void _setName(String name) {
        this.name = name;
    }

    private void _setLastName(String name) {
        this.lastName = lastName;
    }
}
