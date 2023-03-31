package mvc;

import java.util.*;

public abstract class AbstractModeleEcoutable implements ModeleEcoutable {
    public List<EcouteurModele> ecouteurs;
    public AbstractModeleEcoutable(List<EcouteurModele> ecouteurs){
        this.ecouteurs=ecouteurs;
    }

    public AbstractModeleEcoutable() {
        this(new ArrayList<>());
    }

    public void ajoutEcouteur(EcouteurModele e){
        this.ecouteurs.add(e);
        e.modeleMisAJour(this);
    }
    public void retraitEcouteur(EcouteurModele e){
        this.ecouteurs.remove(e);
    }
    protected void notifierLesEcouteurs(){
        for(EcouteurModele e: ecouteurs){
            e.modeleMisAJour(this);
        }
    }
}
