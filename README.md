<h1>Vote - Választások</h1>
<h2>Informatika érettségi emelt szintű feladat: 2013. május</h2>
<p>Eszemiszom városában időközi helyhatósági választásokat írtak ki. A városban összesen 12 345 szavazásra jogosult állampolgár van, akiket nyolc választókerületbe soroltak.</p>
<p>Minden választókerületben több jelölt is indul, de egy jelölt csak egy választókerületben indulhat. Egy választókerület szavazói az adott választókerületben induló jelöltek közül egy jelöltre adhatnak le szavazatot, de nem kötelező részt venniük a szavazáson. Minden választókerületben az a jelölt nyer, aki a legtöbb szavazatot kapja. (Feltételezheti, hogy egyetlen választókerületben sem alakult ki holtverseny.)</p>
<p>A jelöltek vagy egy párt támogatásával, vagy független jelöltként indulhatnak. Az idei évben a Gyümölcsevők Pártja (GYEP), a Húsevők Pártja (HEP), a Tejivók Szövetsége (TISZ) vagy a Zöldségevők Pártja (ZEP) támogatja a jelölteket.</p>
<p>A szavazás eredményét a szavazatok.txt szóközökkel tagolt fájl tartalmazza, amelynek minden sorában egy-egy képviselőjelölt adatai láthatók.</p> <p>Például:</p>
<pre>
8 149 Zeller Zelma ZEP
6 63 Zsoldos Zsolt -
</pre>
<p>Az első két adat a választókerület sorszáma és a képviselőjelöltre leadott szavazatok száma. Ezt a jelölt vezeték- és utóneve, majd a jelöltet támogató párt hivatalos rövidítése követi. Független jelöltek esetében a párt rövidítése helyett egy kötőjel szerepel. Minden képviselőjelöltnek pontosan egy utóneve van.</p>
<p>Készítsen programot <code><b>valasztas</b></code> néven, amely az alábbi kérdésekre válaszol!</p> 
<p>Minden részfeladat feldolgozása során írja ki a képernyőre a részfeladat sorszámát, (például: <code>2. feladat</code>)! Ahol a felhasználótól kér be adatot, ott írja ki a képernyőre azt is, hogy milyen adatot vár! Az ékezetmentes kiírás is elfogadott.</p>
<ol>
<li>Olvassa be a szavazatok.txt fájl adatait, majd ezek felhasználásával oldja meg a következő feladatokat! Az adatfájlban legfeljebb 100 képviselőjelölt adatai szerepelnek.</li>
<li>Hány képviselőjelölt indult a helyhatósági választáson? A kérdésre egész mondatban válaszoljon az alábbi mintához hasonlóan:
<pre>A helyhatósági választáson 92 képviselőjelölt indult.</pre></li>
<li>Kérje be egy képviselőjelölt vezetéknevét és utónevét, majd írja ki a képernyőre, hogy az illető hány szavazatot kapott! Ha a beolvasott név nem szerepel a nyilvántartásban, úgy jelenjen meg a képernyőn az <code>„Ilyen nevű képviselőjelölt nem szerepel a nyilvántartásban!”</code> figyelmeztetés! A feladat megoldása során feltételezheti, hogy nem indult két azonos nevű képviselőjelölt a választáson.</li>
<li>Határozza meg, hányan adták le szavazatukat, és mennyi volt a részvételi arány! (A részvételi arány azt adja meg, hogy a jogosultak hány százaléka vett részt a szavazáson.) A részvételi arányt két tizedesjegy pontossággal, százalékos formában írja ki a képernyőre!
<p>Például:</p>
<pre>A választáson 5001 állampolgár, a jogosultak 40,51%-a vett részt.</pre></li>
<li>Határozza meg és írassa ki a képernyőre az egyes pártokra leadott szavazatok arányát az összes leadott szavazathoz képest két tizedesjegy pontossággal! A független jelölteket együtt, „Független jelöltek” néven szerepeltesse!
<p>Például:</p>
<pre>Zöldségevők Pártja= 12,34%
Független jelöltek= 23,40%</pre></li>
<li>Melyik jelölt kapta a legtöbb szavazatot? Jelenítse meg a képernyőn a képviselő vezetékés utónevét, valamint az őt támogató párt rövidítését, vagy azt, hogy <code>független</code>! Ha több ilyen képviselő is van, akkor mindegyik adatai jelenjenek meg!</li>
<li>Határozza meg, hogy az egyes választókerületekben kik lettek a képviselők! Írja ki a választókerület sorszámát, a győztes vezeték- és utónevét, valamint az őt támogató párt rövidítését, vagy azt, hogy <code>független</code> egy-egy szóközzel elválasztva a <code>kepviselok.txt</code> nevű szöveges fájlba! Az adatok a választókerületek száma szerinti sorrendben jelenjenek meg! Minden sorba egy képviselő adatai kerüljenek!</li>
</ol>
<hr>
<h3>Források:</h3>
<li><a href="https://www.oktatas.hu/bin/content/dload/erettsegi/feladatok_2013tavasz_emelt/e_inf_13maj_fl.pdf">Feladatlap</a>
<li><a href="https://www.oktatas.hu/bin/content/dload/erettsegi/feladatok_2013tavasz_emelt/e_inffor_13maj_fl.zip">Forrásállományok</a>


