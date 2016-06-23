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

##Sekvenssikaaviot
**Pelin aloitus**

![Sekvenssikaavio pelin aloitus](https://github.com/linili/kertolaskupeli/blob/master/Dokumentaatio/sekvenssikaavio_aloitus.png "Sekvenssikaavio: Pelin aloitus")

**Kysymyskortin kääntö**

![Sekvenssikaavio kysymyksen kääntö onnistuu](https://github.com/linili/kertolaskupeli/blob/master/Dokumentaatio/kysymyksenkaanto_uusi.png "Sekvenssikaavio:_kysymyksen_kääntö_onnistuu")

**Vastauskortin kääntö**

![Sekvenssikaavio: vastauksen kääntö onnistuu](https://github.com/linili/kertolaskupeli/blob/master/Dokumentaatio/vastauskortinkaanto_uusi.png "vastauksen kääntö onnistuu")

[Luokkakaavio](https://github.com/linili/kertolaskupeli/blob/master/Dokumentaatio/muistipeli_luokkakaavio.png "Luokkakaavio")

##Rakennekuvaus
Muistipeli koostuu korteista, jotka tietävät ovatko vastaus- vai kysymyskortteja, ovatko oikein- vai nurinpäin ja ovatko löydettyjä vai ei. Pelitilanne sisältää pöydällä olevat kortit. Logiikka hallitsee pelitilanteen kortteja. Logiikalla on mm. tieto siitä onko kysymys- vai vastauskortin vuoro. Logiikalle käskyjä välittää käyttöliittymä sekä kysymysten- ja vastaustenkuuntelijat. Käyttöliittymä lisää kutakin korttia kohden JButtonin. Kun pelaaja valitsee kysymyskorttia vastaavan JButtonin, kysymystenkuuntelija välittää käskyn logiikalle, joka kääntää kortin. Vastauskortin kääntämisen jälkeen tarkistetaan löytyikö pari. Jos löytyi, logiikka välittää tiedon korteille ja käyttöliittymä päivittää kortit. Jos paria ei löytynyt, vastaustenkuuntelija luo ajastimen, jolla peli saadaan pysähtymään siksi ajaksi, että pelaaja näkee kortit, ennenkuin ne käännetään takaisin. Pelinaloittaja luo uuden pelin käyttämällä luokan korttienarpoja metodia, joka palauttaa pelitilanteen arvotuilla korteilla.

[Käyttö-ohje](https://github.com/linili/kertolaskupeli/blob/master/Dokumentaatio/K%C3%A4ytt%C3%B6-ohje.md)

