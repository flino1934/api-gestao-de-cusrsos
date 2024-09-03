package com.lino.dslearnbds.entities.pk;

import com.lino.dslearnbds.entities.Offer;
import com.lino.dslearnbds.entities.User;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class EnrrolmentPK implements Serializable {//Essa classe vai conter o id de user e oferta para saber qual usuario tem qual oferta e qual oferta tem qual usuario

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "offer_id")
    private Offer offer;

    public EnrrolmentPK() {
    }

    public EnrrolmentPK(User user, Offer offer) {
        this.user = user;
        this.offer = offer;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EnrrolmentPK that = (EnrrolmentPK) o;
        return Objects.equals(user, that.user) && Objects.equals(offer, that.offer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, offer);
    }
}
