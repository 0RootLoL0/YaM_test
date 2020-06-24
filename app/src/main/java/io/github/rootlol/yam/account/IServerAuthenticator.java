package io.github.rootlol.yam.account;

public interface IServerAuthenticator {
    public String signUp (final String email, final String username, final String password);
    public String signIn (final String email, final String password);
}