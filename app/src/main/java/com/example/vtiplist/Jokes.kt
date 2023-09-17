package com.example.vtiplist


class Joke(joke: String, category: String) {
    val jokeText = joke
    val jokeCategory = category

    fun getCategoryText() : String {

        val categoryText : String = when (jokeCategory) {
            categoryList[0] -> "Muži a ženy"
            categoryList[1] -> "Černý humor"
            categoryList[2] -> "Práce"
            categoryList[3] -> "IT"
            else -> "Neznámá kategorie"
        }

        return categoryText
    }
}

class Jokes {

    fun getRandomJoke() : Joke {
        return jokeLists.random()
    }

    fun getCategoryJokes(requiredCategory: String): List<Joke> {
        return jokeLists.filter { it.jokeCategory == requiredCategory }
    }


//    val categoryList = listOf<String>(
//        "muzi_zeny",
//        "cerny_humor",
//        "prace",
//        "IT"
//    )

    val jokeLists = listOf<Joke>(
        Joke("Můj ex mě chtěl ztrapnit před svými kamarády...\n" +
                "Řekl, že jsem špatná v posteli...\n" +
                "No, měli jste vidět ten výraz, když s ním ani jeden nesouhlasil.", categoryList[0]),
        Joke("ON: \"Moje hodinky ukazujou, že nemáš kalhotky.\"\n" +
                "ONA: \"Ale já je mám.\"\n" +
                "ON: \"Aha, tak to mi jdou napřed.\"", categoryList[0]),
        Joke("Kluk: \"Něco bych lízal.. Ale ne, že to špatně pochopíš!\"\n" +
                "Holka: \"Hmmm, aha. Tak pojďme na zmrzlinu.\"\n" +
                "Kluk: \"Věděl jsem, že to špatně pochopíš.\"", categoryList[0]),
        Joke("Chlap volá domů ženě - honem přijeď za mnou do práce, mám na to hroznou chuť, rozdáme si to na pracovním stole.\n" +
                "Žena: Vždyť tam máš sekretářku...\n" +
                "Manžel: Fakt? Můžu? Tak díky a ahoj....", categoryList[0]),
        Joke("Povídají si dvě kamarádky:\n" +
                "\"No představ si, co ten můj včera udělal. Normálně jdu do mrazáku, hledám kuře a ten můj přijde, vyhrne mi sukni a strčí mi ho tam.\"\n" +
                "\"Buď ráda, že je takovej aktivní.\"\n" +
                "\"No jo, jenže my jsme byli v Lidlu.\" ", categoryList[0]),
        Joke("On: Jsi taková pěkná, atraktivní a roztomilá.\n" +
                "Ona: Říkáš to jen, abys mě dostal do postele!\n" +
                "On: A dokonce i chytrá! :D", categoryList[0]),
        Joke("Proč je lepší sex s učitelkou, než se zdravotní sestrou?\n" +
                "Zdravotní sestra říká: \"Další prosím!\" \n" +
                "Učitelka říká: \"Celé si to zopakujeme!\"", categoryList[0]),
        Joke("Kluk: \"Já bych chtěl udělat něco hloupého...\" \n" +
                "Holka: \"Já jsem hloupá, udělej mě!\"", categoryList[0]),
        Joke("Když žena otěhotní, všechny její kamarádky hladí její břicho a povídají: \"Gratulujem!\" \n" +
                "Ale žádná nepohladí penis a nepoví: \"Dobrá práce.\"", categoryList[0]),
        Joke("Na pláži se ptá malá Anička maminky: \"Co to tu má ten chlapeček?\"Mamička se zarazila, avšak neztratila duchapřítomnost a pověděla první hloupost, která jí napadla.\"Víš, to je taká píšťalička.\"Za chvíli malá Anička přiběhne z pláčem a povídá mamince: \"Mamí ona mu ale nepíská!\"", categoryList[0]),
        Joke("V kině:\n" +
                "\"Můžu tě políbit?\"\n" +
                "\"Mě? Vždyť jsem ti ho teď vykouřila...\"\n" +
                "\"Mně?!\"", categoryList[0]),
        Joke("\"Mám doma obálku, do které dávám deset korun za každý sex s manželkou.\n" +
                "Na Vánoce jí pak za to koupím nějaký dárek. \n" +
                "Předloni dostala Fidorku, loni už nic.\"", categoryList[0]),
        Joke("Milenci ráno po milování. \n" +
                "\"Máš mě rád?\"\n" +
                "\"Ano mám.\"\n" +
                "\"A udeláš něco pro mě?\"\n" +
                "\"Všechno na světě.\"\n" +
                "\"Tak mě prosím dnes nevyvolávej z matiky...\"", categoryList[0]),
        Joke("Vědecký průzkum na téma \"proč muži v noci vstávají z postele\" ukázal, že:\n" +
                "5 % se musí napít,\n" +
                "12 % musí na záchod,\n" +
                "83 % musí domů.", categoryList[0]),
        Joke("On: \"Drahá, rád bych tě upozornil, že jsme již měsíc neměli sex.\"\n" +
                "Ona: \"Mluv za sebe, drahý..\"", categoryList[0]),
        Joke("Ten trapný okamžik když chodíte s Číňankou, řeknete jí, že chcete šedesát devítku a ona uvaří kung-pao.", categoryList[0]),
        Joke("Sedí v jedné cele pedofil, nekrofil, zoofil, sadista a vyznavač adrenalinových sportů. \n" +
                "Najednou zoofil povídá :\"Kdyby tu tak byla kočka.\" \n" +
                "Pedofil na to: \"Já bych radši koťátko.\" \n" +
                "Nekrofil odpoví \"Mrtvý.\" \n" +
                "Sadista zakřičí: \"Já bych ho zabil.\" \n" +
                "Vyznavač adrenalinových sportů kouká po cele a pak řekne: \"MŇAU!\"", categoryList[0]),
        Joke("Souloží spolu bratr a sestra: \"Brácha, Ty jseš v posteli lepší než táta!\"\n" +
                "Bratr na to: \"Já vím, máma mi to taky říkala!\"", categoryList[0]),
        Joke("Přijde chlápek k doktorovi na prohlídku a doktor se ho po chvíli ptá: Masturbuje?\n" +
                "Muž se začervená a říká \"Ano\"\n" +
                "\"A mohl byste s tím na chvíli přestat?\"", categoryList[0]),
        Joke("Dvě děvky si povídaj. \"Mařko, a kouříš?\" \"Jo.\" \"A za jak dlouho vykouříš spartu?\" \"I s trenérem tak za hodinu a něco.\"", categoryList[0]),
        Joke("\"Terezo, dej mi pusu!\"\n" +
                "\"Nedám, jsem šťastně vdaná, správně bych ti ho neměla ani kouřit.\"", categoryList[0]),
        Joke("Po milování říká lehká děva malomocnému: \"Víš, já mám AIDS!\"\n" +
                "Malomocný si utře zpocené čelo a říká: \"No ještě, že jsem ho tam nechal!\"", categoryList[0]),
        Joke("Chlap vstoupí do ložnice s kozou v náručí... Jeho žena leží na posteli a čte si knížku..\n" +
                "Chlap povídá:\n" +
                "\"Koukej miláčku, toto je ta kráva, s kterou píchám, když máš ty krámy..\"\n" +
                "Žena mu odpovídá:\n" +
                "\"Kdyby si nebyl takovej čurák, tak víš, že je to koza..\"\n" +
                "Chlap se jen usměje:\n" +
                "\"Kdyby si nebyla taková píča, tak si všimneš, že se nebavim s tebou..\"", categoryList[0]),
        //Joke("", categoryList[0]),
        // ----------------------------------------------------------------------------------------
        Joke("Sedí indián u vodopádu a kouká na svou ženu jak pere prádlo.\n" +
                "V tom z vodopádu spadne kámen jeho ženě na hlavu a zabije ji.\n" +
                "Indián zkušeně: \"To už je třetí pračka, kterou mi zničil vodní kámen.\"", categoryList[1]),
        Joke("Moje holka mi řekla, že jsem pedofil, myslím si, že vcelku silné slova na sedmiletou.", categoryList[1]),
        Joke("Pletou dvě nastávající maminky malé svetříky pro své ratolesti a jedna říká: \n" +
                "\"Doufám že to bude chlapeček, mám jenom modrou přízi.\"\n" +
                "Druhá říká:\n" +
                "\"Doufám že to bude kripl, zkurvila jsem rukáv.\"", categoryList[1]),
        Joke("Když někdo umře, tak o tom neví, ale pro ostatní je to těžké...\n" +
                "To samé platí, když je někdo debil.", categoryList[1]),
        Joke("Víte co znamená pro lidožrouta těhotná žena?\n" +
                "Kinder vejce.", categoryList[1]),
        Joke("Černý humor je jako dítě z Afgánistánu. Nemá hlavu, ani patu.", categoryList[1]),
        Joke("Šly děti po minovém poli a rozhazovaly rukama... některé i 30 metrů!", categoryList[1]),
        Joke("Má to čtyři nohy a jednu ruku. Co to je?\n" +
                "Pitbul na dětském hřišti.\n", categoryList[1]),
        Joke("Jdou dva staříci po silnici a najednou kolem nich projede na motorce bezhlavý muž.\n" +
                "Jdou dál a opět kolem nich projede bezhlavý chlap na motorce.\n" +
                "Když se to opakuje už po páté, ten jeden stařík říká tomu druhému: \"Hele, Franto, nechceš si tu kosu dát na druhý rameno?\"", categoryList[1]),
        Joke("Víte, jaký je oblíbený nápoj vozíčkářů?\n" +
                "Točená kola.", categoryList[1]),
        Joke("Víte, co máte udělat, když znásilníte hluchoněmou?\n" +
                "Zlomit jí ruce, ať to nikde nevykecá.", categoryList[1]),
        Joke("Jaká jsou nejčastější zranění při požáru základní školy?\n" +
                "Popáleniny prvního a druhého stupně.", categoryList[1]),
        Joke("\"Ahoj. Jmenuji se Mirek\uFEFF a chtěl bych nechat zahrát písničku od Pavla Vítka - Mám rád vůni Tvý kůže.\n" +
                "Bude to pro mou tchyni, která včera uhořela.\"", categoryList[1]),
        Joke("Pacient se ptá doktora: \"Proč si nemohu nahmatat nohy?\"\n" +
                "Doktor: \"Protože jsme vám amputovali ruce!\"", categoryList[1]),
        Joke("Holčička: \"Tatínku, já bych chtěla na Vánoce pejska.\"\n" +
                "Tatínek: \"Nevymejšlej kraviny. Bude kapr jako vždycky!\"", categoryList[1]),
        Joke("Nepřijde vám přehnané, že váš vyhodí z práce jen kvůli tomu, že vám něco malého upadlo na zem?!\n" +
                "Martina, porodní sestra.", categoryList[1]),
        Joke("Tři dcery a fotr mají autonehodu. Fotr se pak ptá doktora, jak to s těmi dcerami vypadá. Doktor říká:\"" +
                "Ta nejhezčí z nich má úplně rozřezanou držku, ta s nadáním pro balet má amputovanou nohu a ta inteligentni" +
                " má nádor na mozku!\" \"To si děláte srandu\" řekne fotr!\"Ano dělám, jsou všechny mrtvé!!\"", categoryList[1]),
        Joke("\"Mami, já bych chtěla pejska.\"\"Tak si ukroj v ledničce je ještě kousek.\"", categoryList[1]),
        Joke("Přijde pán do lékárny a povídá: \"Dobrý den, potřeboval bych postinor pro mojí 11letu dceru.\"\n" +
                "Lékárnice se udiveně ptá: \"A Vaše dcera je už v 11letech sexuálně aktivní?\"\n" +
                "Pán: \"Ale hovno aktivní, jako prkno, celá manželka.\"", categoryList[1]),
        //Joke("", categoryList[1]),
        // ----------------------------------------------------------------------------------------
        Joke("Sekretářka vstoupí k řediteli:\n" +
                "\"Zdá se, že máte telefon.\"\n" +
                "\"Jak to - zdá se?\"\n" +
                "\"Zvedla jsem sluchátko a v něm se ozvalo - To jsi ty, ty starý kreténe?\"", categoryList[2]),
        Joke("Šéf si zavolá zaměstnance a ptá se: Kdo včera z vás chlastal?\n" +
                "Nikdo se neozývá.\n" +
                "Ptám se naposled: Kdo z vás včera chlastal!\n" +
                "Ozve se jeden: Já!\n" +
                "Tak běž se domů vyspat a ostatní do práce!", categoryList[2]),
        Joke("Přijde sekretářka za šéfem a říká: \n" +
                "\"Mám pro vás dvě zprávy - špatnou a dobrou, kterou chcete slyšet první?\" \n" +
                "\"Začněte tou dobrou.\"\n" +
                "\"Nejste neplodný.\"", categoryList[2]),
        Joke("Jeden státní úředník si postěžuje druhému: \"Já nevím, co proti nám ti lidé pořád mají. Vždyť jsme nic neudělali!\"", categoryList[2]),
        Joke("Šéf mi přišel ukázat vnoučka.\n" +
                "Uslintanej, uřvanej, s tupým výrazem.\n" +
                "To dítě je ale docela hezký.", categoryList[2]),
        Joke("Při přijímacím pohovoru: „Kolik je vám let?”\n" +
                "„No, mám to blíže ke třicítce než ke dvacítce.”\n" +
                "„A kolik je to doopravdy?”\n" +
                "„Padesát.”", categoryList[2]),
        Joke("Říká mistr na stavbě učni: „Hele, nepotrpím si na zbytečný řeči. Když takhle zakejvám ukazováčkem, tak přijdeš, jasný?”\n" +
                "Učeň na to: „To je dobře, pane mistr, že si rozumíme. Když já takhle zvednu prostředníček, znamená to, že nepřijdu.”", categoryList[2]),
        Joke("V práci se ženy začaly hádat. Zavolali vedoucího, aby udělal pořádek.\n" +
                "„Ticho,” vykřikl, „ať mluví nejstarší!”\n" +
                "V tu chvíli všechny zmlkly.", categoryList[2]),
        Joke("Přijde sekretářka za šéfem a povídá: „Šéfe, nechcete si zahrát na internet?”\n" +
                "„A jak se to hraje?”\n" +
                "„Všechno ze mě stáhnete.”", categoryList[2]),
        Joke("Bůh seslal na lidstvo choleru, mor, neštovice, několik světových válek, AIDS, fašismus, komunismus... a nic nepomohlo. Tak vymyslel ISO 9001.", categoryList[2]),
        Joke("Freelancer: „Kolik hodin týdně děláš?”\n" +
                "Zaměstnanec: „Čtyřicet.”\n" +
                "Freelancer: „A od středy do neděle děláš co?”", categoryList[2]),
        //Joke("Ctvrty vtip", categoryList[2]),
        // ----------------------------------------------------------------------------------------
        Joke("„Tatí, co to byl jukebox?”\n" +
                "„No, něco jako iPod, akorát o 400 kg těžší!”", categoryList[3]),
        Joke("Neposlušný bit: zlobit.", categoryList[3]),
        Joke("Operátor: „Ok, nyní klikněte levým tlačítkem.”\n" +
                "Uživatel: „Kterým?”\n" +
                "Operátor: „Na levé straně myši.”\n" +
                "Uživatel: „Ale já jsem levák, mám to přehozené.”\n" +
                "Operátor: „Tak stiskněte tlačítko, které mačkáte běžně.”\n" +
                "Uživatel: „Ale to je pro mě pravý.”\n" +
                "Operátor: „Tak na něj klikněte.”\n" +
                "Uživatel: „Kterou rukou?”", categoryList[3]),
        Joke("Chlubí se počítačový nadšenec manželce: „Mám SSD.”\n" +
                "A ona na to: „A dá se to léčit?”", categoryList[3]),
        Joke("Nefunguje Facebook a trvá to už třetí den...!\n" +
                "Zoufalí lide vybíhají do ulic, v rukou drží své fotografie a tablety s videi a křičí na ostatní: „Líbí se ti to, líbí se ti to?!”", categoryList[3]),
        Joke("Na počítači mi vyskočilo: „Program provedl neplatnou operaci.”\n" +
                "Pane bože, co mi asi vyoperoval?!", categoryList[3]),
        Joke("Když se zaváděla nová technologie Plug & Play, tak se vyskytla tisková chyba - správně má být Plug & Pray.", categoryList[3]),
        Joke("Kdyby stavitelé stavěli budovy stejným způsobem, jako programátoři Microsoftu píší programy, pak první datel, který by se vyskytl poblíž, by zničil civilizaci.", categoryList[3]),
        Joke("Na vsi nazývají ajťákem toho, kdo umí zapnout a vypnout počítač.", categoryList[3]),
        Joke("Ajťák se dobývá do nebe, buší na nebeskou bránu a křičí: „Proč mě nechcete pustit dovnitř?”\n" +
                "Ukáže se svatý Petr, hodí po něm Bibli a říká: „RTFM!!!”", categoryList[3]),
        Joke("Mějte úctu ke svým rodičům.\n" +
                "Dokončili školy bez Googlu a Wikipedie.", categoryList[3]),
        Joke("Přišel jsem náhle o všechny přátele.\n" +
                "Zapomněl jsem heslo na Facebook.", categoryList[3]),
        Joke("„Problém citací na internetu je ten, že si nikdy nemůžeme být jisti, zda jsou pravé.”\n" +
                "Josef Čapek", categoryList[3]),
        Joke("Čeština prochází krásným vývojem: Zatímco naši rodiče chataří, my chatujem.", categoryList[3]),
        Joke("Programátor je u očního. Doktor ho usadí a povídá: „Čtěte!”\n" +
                "„T F U K M C L... Pane doktore, máte dobře nastavené kódování?”", categoryList[3]),
        Joke("Počítač je zařízení k řešení problémů, které by bez něj vůbec nevznikly.", categoryList[3]),
        Joke("Po týdnu bez počítače s internetem jsem si uvědomil, co je v životě opravdu podstatné a důležité.\n" +
                "Je to počítač a internet.", categoryList[3]),
        Joke("Pepíček: „Tatííí, je pravda, že nadměrné užívání internetu snižuje slovní zásobu???”\n" +
                "Tatínek: „IMHO LOL.”", categoryList[3]),
        Joke("Co říká bezpečnostní software chycenému červovi?\n" +
                "„Jsi zatčen! A nezkoušej na mě žádný fork()y!”", categoryList[3]),
        Joke("Jede webmaster ve vlaku a slyší: „<td></td> ... <td></td> ... <td></td>”", categoryList[3]),
        Joke("Jak poznáte uživatele Applu?\n" +
                "Řekne vám to.", categoryList[3]),
        Joke("Znáte ten pocit, když pro něco jdete a záhy zapomenete, pro co?\n" +
                "Tak to Bůh hraje Sims a právě dal zrušit akci.", categoryList[3]),
        Joke("Na pohřbu: „Jaké je heslo na WiFi?”\n" +
                "„Proboha, mějte úctu k mrtvým!”\n" +
                "„Všechno malým?”", categoryList[3]),
        Joke("Java je jako Alzheimerova choroba.\n" +
                "Začíná pomalu, ale nakonec je pryč vaše paměť.", categoryList[3]),
        Joke("„Hele, padá hvězda, něco si přej!”\n" +
                "„Přeji si, abych měl místo pupku USB port na nabíječku mobilního telefonu.”\n" +
                "„Nejseš ty idiot?”\n" +
                "„Proč?”\n" +
                "„No, přání se přece nesmí říkat nahlas!”", categoryList[3]),
        Joke("Chovejte se k programátorům. jako by to byli normální lidé.", categoryList[3]),
        //Joke("", categoryList[3]),
        // ----------------------------------------------------------------------------------------
    )
}
