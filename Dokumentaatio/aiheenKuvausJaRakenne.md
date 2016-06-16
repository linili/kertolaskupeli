#Aihemäärittely
**Aihe:**
Muistipeli kertolaskujen opetteluun. Peli koostuu korteista, joissa toisissa lukee kertolaskuja (esim. 8 x 4) ja toisissa vastaukset (esim. 32). Peli aloitetaan kysymällä pelaajalta, minkä kertotaulun korteilla hän haluaa pelata (1-9). Peli arpoo muistipelin korteille järjestyksen näyttämättä, mitä niissä lukee. Kertolaskut eli kysymykset asetetaan yläriville ja vastaukset alariville. Pelaaja valitsee kysymyksistä yhden kortin, jonka jälkeen kortti näytetään pelaajalle. Tämän jälkeen pelaaja valitsee vastauksista kortin, joka näytetään pelaajalle. Jos kortit sopivat yhteen (kertolasku ja vastaus täsmäävät), ne jäävät näkyviin. Muussa tapauksessa kortit käännetään pois näkyvistä. Peliä jatketaan, kunnes kaikki parit on löydetty. Tämän jälkeen pelaajalta kysytään haluaako hän pelata uuden pelin vai lopettaa.

**Käyttäjät:**
Pelaaja

**Käyttäjien toiminnot:**

- Pelin käynnistäminen
- Pelaaja voi valita minkä kertotaulun laskuista koostuvan pelin hän haluaa
- Kysymyskortin valitseminen
- Vastaukortin valitseminen
- Pelin lopettaminen

![Sekvenssikaavio pelin aloitus](https://github.com/linili/kertolaskupeli/blob/master/Dokumentaatio/sekvenssikaavio_OnnistunutKysymyksenKaanto.png "Sekvenssikaavio: Pelin aloitus")
![Sekvenssikaavio kysymyksen kääntö onnistuu](https://github.com/linili/kertolaskupeli/blob/master/Dokumentaatio/sekvenssikaavio_OnnistunutKysymyksenKaanto.png "Sekvenssikaavio:_kysymyksen_kääntö_onnistuu")
![Sekvenssikaavio: vastauksen kääntö onnistuu](https://github.com/linili/kertolaskupeli/blob/master/Dokumentaatio/sekvenssikaavio_OnnistunutVastauskortinKaanto.png "vastauksen kääntö onnistuu")
