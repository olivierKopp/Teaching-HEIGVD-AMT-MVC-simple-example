package ch.heigvd.amt.mvcsimple.business;

import ch.heigvd.amt.mvcsimple.model.Profile;

public class InfoChecker {

    public boolean checkinfo(Profile p){
        return !p.getUsername().isEmpty() && !p.getPassword().isEmpty() && !p.getMail().isEmpty() && p.getMail().contains(String.valueOf('@'));
    }

    public boolean checkNotEmpty (String s){
        return !s.isEmpty();
    }

    public boolean checkMail (String s){
        return s.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" );
    }

}
