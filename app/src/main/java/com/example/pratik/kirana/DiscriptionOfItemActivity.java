package com.example.pratik.kirana;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import static com.example.pratik.kirana.R.string.setText1DescBarbie;
import static com.example.pratik.kirana.R.string.setText2DescBarbie;
import static com.example.pratik.kirana.R.string.setText3DescBarbie;

public class DiscriptionOfItemActivity extends AppCompatActivity {

    String gettingValueTypeOfItem, allDescriptionContentString,textFromSpinnerDescriptionOne, textFromSpinnerDescriptionTwo,
            textFromSpinnerDescriptionThree,textFromSpinnerDescriptionFour, textFromSpinnerDescriptionFive;
            /*, textFromtextViewDescriptionOne,textFromtextViewDescriptionTwo,textFromtextViewDescriptionThree,
            textFromtextViewDescriptionFour, textFromtextViewDescriptionFive,*/

    TextView textViewDescriptionOne, textViewDescriptionTwo, textViewDescriptionThree, textViewDescriptionFour, textViewDescriptionFive,
            textViewOfFullDescription;
    Spinner spinnerDescriptionOne, spinnerDescriptionTwo, spinnerDescriptionThree, spinnerDescriptionFour, spinnerDescriptionFive;
    Button buttonSubmitInDescriptionActivity, buttonCheckDescriptionInDescriptionActivity;

    //Array for the Barbie Description
    String[] BarbieDescriptionFirst = {"1DescBarbieA", "1DescBarbieB", "1DescBarbieC", "1DescBarbieD", "1DescBarbieE"};
    String[] BarbieDescriptionSecond = {"2DescBarbieA", "2DescBarbieB", "2DescBarbieC", "2DescBarbieD", "2DescBarbieE"};
    String[] BarbieDescriptionThird = {"3DescBarbieA", "3DescBarbieB", "3DescBarbieC", "3DescBarbieD", "3DescBarbieE"};
    String[] BarbieDescriptionFourth = {"4DescBarbieA", "4DescBarbieB", "4DescBarbieC", "4DescBarbieD", "4DescBarbieE"};
    String[] BarbieDescriptionFifth = {"5DescBarbieA", "5DescBarbieB", "5DescBarbieC", "5DescBarbieD", "5DescBarbieE"};

    //Array for the Bleutooth Description
    String[] BluetoothDescriptionFirst = {"1DescBluetoothA", "1DescBluetoothB", "1DescBluetoothC", "1DescBluetoothD", "1DescBluetoothE"};
    String[] BluetoothDescriptionSecond = {"2DescBluetoothA", "2DescBluetoothB", "2DescBluetoothC", "2DescBluetoothD", "2DescBluetoothE"};
    String[] BluetoothDescriptionThird = {"3DescBluetoothA", "3DescBluetoothB", "3DescBluetoothC", "3DescBluetoothD", "3DescBluetoothE"};
    String[] BluetoothDescriptionFourth = {"4DescBluetoothA", "4DescBluetoothB", "4DescBluetoothC", "4DescBluetoothD", "4DescBluetoothE"};
    String[] BluetoothDescriptionFifth = {"5DescBluetoothA", "5DescBluetoothB", "5DescBluetoothC", "5DescBluetoothD", "5DescBluetoothE"};

    //Array for the Car Toys Description
    String[] CarToysDescriptionFirst = {"1DescCarToysA", "1DescCarToysB", "1DescCarToysC", "1DescCarToysD", "1DescCarToysE"};
    String[] CarToysDescriptionSecond = {"2DescCarToysA", "2DescCarToysB", "2DescCarToysC", "2DescCarToysD", "2DescCarToysE"};
    String[] CarToysDescriptionThird = {"3DescCarToysA", "3DescCarToysB", "3DescCarToysC", "3DescCarToysD", "3DescCarToysE"};
    String[] CarToysDescriptionFourth = {"4DescCarToysA", "4DescCarToysB", "4DescCarToysC", "4DescCarToysD", "4DescCarToysE"};
    String[] CarToysDescriptionFifth = {"5DescCarToysA", "5DescCarToysB", "5DescCarToysC", "5DescCarToysD", "5DescCarToysE"};

    //Array for the Charger Description
    String[] ChargerDescriptionFirst = {"1DescCarToysA", "1DescCarToysB", "1DescCarToysC", "1DescCarToysD", "1DescCarToysE"};
    String[] ChargerDescriptionSecond = {"2DescCarToysA", "2DescCarToysB", "2DescCarToysC", "2DescCarToysD", "2DescCarToysE"};
    String[] ChargerDescriptionThird = {"3DescCarToysA", "3DescCarToysB", "3DescCarToysC", "3DescCarToysD", "3DescCarToysE"};
    String[] ChargerDescriptionFourth = {"4DescCarToysA", "4DescCarToysB", "4DescCarToysC", "4DescCarToysD", "4DescCarToysE"};
    String[] ChargerDescriptionFifth = {"5DescCarToysA", "5DescCarToysB", "5DescCarToysC", "5DescCarToysD", "5DescCarToysE"};

    //Array for the Children's Books Description
    String[] ChildrensBooksDescriptionFirst = {"1DescChildren's BooksA", "1DescChildren's BooksB", "1DescChildren's BooksC", "1DescChildren's BooksD", "1DescChildren's BooksE"};
    String[] ChildrensBooksDescriptionSecond = {"2DescChildren's BooksA", "2DescChildren's BooksB", "2DescChildren's BooksC", "2DescChildren's BooksD", "2DescChildren's BooksE"};
    String[] ChildrensBooksDescriptionThird = {"3DescChildren's BooksA", "3DescChildren's BooksB", "3DescChildren's BooksC", "3DescChildren's BooksD", "3DescChildren's BooksE"};
    String[] ChildrensBooksDescriptionFourth = {"4DescChildren's BooksA", "4DescChildren's BooksB", "4DescChildren's BooksC", "4DescChildren's BooksD", "4DescChildren's BooksE"};
    String[] ChildrensBooksDescriptionFifth = {"5DescChildren's BooksA", "5DescChildren's BooksB", "5DescChildren's BooksC", "5DescChildren's BooksD", "5DescChildren's BooksE"};

    //Array for the Computer Description
    String[] ComputerBooksDescriptionFirst = {"1DescCarToysA", "1DescCarToysB", "1DescCarToysC", "1DescCarToysD", "1DescCarToysE"};
    String[] ComputerBooksDescriptionSecond = {"2DescCarToysA", "2DescCarToysB", "2DescCarToysC", "2DescCarToysD", "2DescCarToysE"};
    String[] ComputerBooksDescriptionThird = {"3DescCarToysA", "3DescCarToysB", "3DescCarToysC", "3DescCarToysD", "3DescCarToysE"};
    String[] ComputerBooksDescriptionFourth = {"4DescCarToysA", "4DescCarToysB", "4DescCarToysC", "4DescCarToysD", "4DescCarToysE"};
    String[] ComputerBooksDescriptionFifth = {"5DescCarToysA", "5DescCarToysB", "5DescCarToysC", "5DescCarToysD", "5DescCarToysE"};

    //Array for the Children's Fashion Description
    String[] ChildrensFashionDescriptionFirst = {"1DescChildren's FashionA", "1DescChildren's FashionB", "1DescChildren's FashionC", "1DescChildren's FashionD", "1DescChildren's FashionE"};
    String[] ChildrensFashionDescriptionSecond = {"2DescChildren's FashionA", "2DescChildren's FashionB", "2DescChildren's FashionC", "2DescChildren's FashionD", "2DescChildren's FashionE"};
    String[] ChildrensFashionDescriptionThird = {"3DescChildren's FashionA", "3DescChildren's FashionB", "3DescChildren's FashionC", "3DescChildren's FashionD", "3DescChildren's FashionE"};
    String[] ChildrensFashionDescriptionFourth = {"4DescChildren's FashionA", "4DescChildren's FashionB", "4DescChildren's FashionC", "4DescChildren's FashionD", "4DescChildren's FashionE"};
    String[] ChildrensFashionDescriptionFifth = {"5DescChildren's FashionA", "5DescChildren's FashionB", "5DescChildren's FashionC", "5DescChildren's FashionD", "5DescChildren's FashionE"};

    //Array for the Fan Description
    String[] FanDescriptionFirst = {"1DescFanA", "1DescFanB", "1DescFanC", "1DescFanD", "1DescFanE"};
    String[] FanDescriptionSecond = {"2DescFanA", "2DescFanB", "2DescFanC", "2DescFanD", "2DescFanE"};
    String[] FanDescriptionThird = {"3DescFanA", "3DescFanB", "3DescFanC", "3DescFanD", "3DescFanE"};
    String[] FanDescriptionFourth = {"4DescFanA", "4DescFanB", "4DescFanC", "4DescFanD", "4DescFanE"};
    String[] FanDescriptionFifth = {"5DescFanA", "5DescFanB", "5DescFanC", "5DescFanD", "5DescFanE"};

    //Array for the Gents Watches Description
    String[] GentsWatchesDescriptionFirst = {"1DescGentsWatchA", "1DescGentsWatchB", "1DescGentsWatchC", "1DescGentsWatchD", "1DescGentsWatchE"};
    String[] GentsWatchesDescriptionSecond = {"2DescGentsWatchA", "2DescGentsWatchB", "2DescGentsWatchC", "2DescGentsWatchD", "2DescGentsWatchE"};
    String[] GentsWatchesDescriptionThird = {"3DescGentsWatchA", "3DescGentsWatchB", "3DescGentsWatchC", "3DescGentsWatchD", "3DescGentsWatchE"};
    String[] GentsWatchesDescriptionFourth = {"4DescGentsWatchA", "4DescGentsWatchB", "4DescGentsWatchC", "4DescGentsWatchD", "4DescGentsWatchE"};
    String[] GentsWatchesDescriptionFifth = {"5DescGentsWatchA", "5DescGentsWatchB", "5DescGentsWatchC", "5DescGentsWatchD", "5DescGentsWatchE"};

    //Array for the Headsets Description
    String[] HeadsetsDescriptionFirst = {"1DescHeadsetsA", "1DescHeadsetsB", "1DescHeadsetsC", "1DescHeadsetsD", "1DescHeadsetsE"};
    String[] HeadsetsDescriptionSecond = {"2DescHeadsetsA", "2DescHeadsetsB", "2DescHeadsetsC", "2DescHeadsetsD", "2DescHeadsetsE"};
    String[] HeadsetsDescriptionThird = {"3DescHeadsetsA", "3DescHeadsetsB", "3DescHeadsetsC", "3DescHeadsetsD", "3DescHeadsetsE"};
    String[] HeadsetsDescriptionFourth = {"4DescHeadsetsA", "4DescHeadsetsB", "4DescHeadsetsC", "4DescHeadsetsD", "4DescHeadsetsE"};
    String[] HeadsetsDescriptionFifth = {"5DescHeadsetsA", "5DescHeadsetsB", "5DescHeadsetsC", "5DescHeadsetsD", "5DescHeadsetsE"};

    //Array for the Headphones Description
    String[] HeadphonesDescriptionFirst = {"1DescHeadphonesA", "1DescHeadphonesB", "1DescHeadphonesC", "1DescHeadphonesD", "1DescHeadphonesE"};
    String[] HeadphonesDescriptionSecond = {"2DescHeadphonesA", "2DescHeadphonesB", "2DescHeadphonesC", "2DescHeadphonesD", "2DescHeadphonesE"};
    String[] HeadphonesDescriptionThird = {"3DescHeadphonesA", "3DescHeadphonesB", "3DescHeadphonesC", "3DescHeadphonesD", "3DescHeadphonesE"};
    String[] HeadphonesDescriptionFourth = {"4DescHeadphonesA", "4DescHeadphonesB", "4DescHeadphonesC", "4DescHeadphonesD", "4DescHeadphonesE"};
    String[] HeadphonesDescriptionFifth = {"5DescHeadphonesA", "5DescHeadphonesB", "5DescHeadphonesC", "5DescHeadphonesD", "5DescHeadphonesE"};

    //Array for the Home Theater Description
    String[] HomeTheaterDescriptionFirst = {"1DescHomeTheaterA", "1DescHomeTheaterB", "1DescHomeTheaterC", "1DescHomeTheaterD", "1DescHomeTheaterE"};
    String[] HomeTheaterDescriptionSecond = {"2DescHomeTheaterA", "2DescHomeTheaterB", "2DescHomeTheaterC", "2DescHomeTheaterD", "2DescHomeTheaterE"};
    String[] HomeTheaterDescriptionThird = {"3DescHomeTheaterA", "3DescHomeTheaterB", "3DescHomeTheaterC", "3DescHomeTheaterD", "3DescHomeTheaterE"};
    String[] HomeTheaterDescriptionFourth = {"4DescHomeTheaterA", "4DescHomeTheaterB", "4DescHomeTheaterC", "4DescHomeTheaterD", "4DescHomeTheaterE"};
    String[] HomeTheaterDescriptionFifth = {"5DescHomeTheaterA", "5DescHomeTheaterB", "5DescHomeTheaterC", "5DescHomeTheaterD", "5DescHomeTheaterE"};

    //Array for the Hard Disks Description
    String[] HardDisksDescriptionFirst = {"1DescHardDisksA", "1DescHardDisksB", "1DescHardDisksC", "1DescHardDisksD", "1DescHardDisksE"};
    String[] HardDisksDescriptionSecond = {"2DescHardDisksA", "2DescHardDisksB", "2DescHardDisksC", "2DescHardDisksD", "2DescHardDisksE"};
    String[] HardDisksDescriptionThird = {"3DescHardDisksA", "3DescHardDisksB", "3DescHardDisksC", "3DescHardDisksD", "3DescHardDisksE"};
    String[] HardDisksDescriptionFourth = {"4DescHardDisksA", "4DescHardDisksB", "4DescHardDisksC", "4DescHardDisksD", "4DescHardDisksE"};
    String[] HardDisksDescriptionFifth = {"5DescHardDisksA", "5DescHardDisksB", "5DescHardDisksC", "5DescHardDisksD", "5DescHardDisksE"};

    //Array for the Keyboard Description
    String[] KeyboardDescriptionFirst = {"1DescKeyboardA", "1DescKeyboardB", "1DescKeyboardC", "1DescKeyboardD", "1DescKeyboardE"};
    String[] KeyboardDescriptionSecond = {"2DescKeyboardA", "2DescKeyboardB", "2DescKeyboardC", "2DescKeyboardD", "2DescKeyboardE"};
    String[] KeyboardDescriptionThird = {"3DescKeyboardA", "3DescKeyboardB", "3DescKeyboardC", "3DescKeyboardD", "3DescKeyboardE"};
    String[] KeyboardDescriptionFourth = {"4DescKeyboardA", "4DescKeyboardB", "4DescKeyboardC", "4DescKeyboardD", "4DescKeyboardE"};
    String[] KeyboardDescriptionFifth = {"5DescKeyboardA", "5DescKeyboardB", "5DescKeyboardC", "5DescKeyboardD", "5DescKeyboardE"};

    //Array for the Laptop Description
    String[] LaptopDescriptionFirst = {"1DescLaptopA", "1DescLaptopB", "1DescLaptopC", "1DescLaptopD", "1DescLaptopE"};
    String[] LaptopDescriptionSecond = {"2DescLaptopA", "2DescLaptopB", "2DescLaptopC", "2DescLaptopD", "2DescLaptopE"};
    String[] LaptopDescriptionThird = {"3DescLaptopA", "3DescLaptopB", "3DescLaptopC", "3DescLaptopD", "3DescLaptopE"};
    String[] LaptopDescriptionFourth = {"4DescLaptopA", "4DescLaptopB", "4DescLaptopC", "4DescLaptopD", "4DescLaptopE"};
    String[] LaptopDescriptionFifth = {"5DescLaptopA", "5DescLaptopB", "5DescLaptopC", "5DescLaptopD", "5DescLaptopE"};

    //Array for the Light Bulbs Description
    String[] LightBulbsDescriptionFirst = {"1DescLightBulbsA", "1DescLightBulbsB", "1DescLightBulbsC", "1DescLightBulbsD", "1DescLightBulbsE"};
    String[] LightBulbsDescriptionSecond = {"2DescLightBulbsA", "2DescLightBulbsB", "2DescLightBulbsC", "2DescLightBulbsD", "2DescLightBulbsE"};
    String[] LightBulbsDescriptionThird = {"3DescLightBulbsA", "3DescLightBulbsB", "3DescLightBulbsC", "3DescLightBulbsD", "3DescLightBulbsE"};
    String[] LightBulbsDescriptionFourth = {"4DescLightBulbsA", "4DescLightBulbsB", "4DescLightBulbsC", "4DescLightBulbsD", "4DescLightBulbsE"};
    String[] LightBulbsDescriptionFifth = {"5DescLightBulbsA", "5DescLightBulbsB", "5DescLightBulbsC", "5DescLightBulbsD", "5DescLightBulbsE"};

    //Array for the Ladies Watches Description
    String[] LadiesWatchesDescriptionFirst = {"1DescLadiesWatchesA", "1DescLadiesWatchesB", "1DescLadiesWatchesC", "1DescLadiesWatchesD", "1DescLadiesWatchesE"};
    String[] LadiesWatchesDescriptionSecond = {"2DescLadiesWatchesA", "2DescLadiesWatchesB", "2DescLadiesWatchesC", "2DescLadiesWatchesD", "2DescLadiesWatchesE"};
    String[] LadiesWatchesDescriptionThird = {"3DescLadiesWatchesA", "3DescLadiesWatchesB", "3DescLadiesWatchesC", "3DescLadiesWatchesD", "3DescLadiesWatchesE"};
    String[] LadiesWatchesDescriptionFourth = {"4DescLadiesWatchesA", "4DescLadiesWatchesB", "4DescLadiesWatchesC", "4DescLadiesWatchesD", "4DescLadiesWatchesE"};
    String[] LadiesWatchesDescriptionFifth = {"5DescLadiesWatchesA", "5DescLadiesWatchesB", "5DescLadiesWatchesC", "5DescLadiesWatchesD", "5DescLadiesWatchesE"};

    //Array for the Magzines Description
    String[] MagzinesDescriptionFirst = {"1DescMagzinesA", "1DescMagzinesB", "1DescMagzinesC", "1DescMagzinesD", "1DescMagzinesE"};
    String[] MagzinesDescriptionSecond = {"2DescMagzinesA", "2DescMagzinesB", "2DescMagzinesC", "2DescMagzinesD", "2DescMagzinesE"};
    String[] MagzinesDescriptionThird = {"3DescMagzinesA", "3DescMagzinesB", "3DescMagzinesC", "3DescMagzinesD", "3DescMagzinesE"};
    String[] MagzinesDescriptionFourth = {"4DescMagzinesA", "4DescMagzinesB", "4DescMagzinesC", "4DescMagzinesD", "4DescMagzinesE"};
    String[] MagzinesDescriptionFifth = {"5DescMagzinesA", "5DescMagzinesB", "5DescMagzinesC", "5DescMagzinesD", "5DescMagzinesE"};

    //Array for the Mobiles Description
    String[] MobilesDescriptionFirst = {"4 GB", "2 GB", "3 GB", "1 GB", "512 MB"};
    String[] MobilesDescriptionSecond = {"Kitkat 4.4.4", "Lollipop 5.0.1", "Marshmalow 6.0", "Kitkat 4.2.2"};
    String[] MobilesDescriptionThird = {"Intel quode core 4 Ghz", "Intel quode core 2 Ghz", "Intel quode core 3 Ghz", "Intel quode core 1"};
    String[] MobilesDescriptionFourth = {"16 GB", "8 GB", "12 GB", "32 GB"};
    String[] MobilesDescriptionFifth = {"5DescMobilesA", "5DescMobiles", "5DescMobilesC", "5DescMobilesD", "5DescMobilesE"};

    //Array for the Mobile Battery Description
    String[] MobileBatteryDescriptionFirst = {"1DescMobileBatteryA", "1DescMobileBatteryB", "1DescMobileBatteryC", "1DescMobileBatteryD", "1DescMobileBatteryE"};
    String[] MobileBatteryDescriptionSecond = {"2DescMobileBatteryA", "2DescMobileBatteryB", "2DescMobileBatteryC", "2DescMobileBatteryD", "2DescMobileBatteryE"};
    String[] MobileBatteryDescriptionThird = {"3DescMobileBatteryA", "3DescMobileBatteryB", "3DescMobileBatteryC", "3DescMobileBatteryD", "3DescMobileBatteryE"};
    String[] MobileBatteryDescriptionFourth = {"4DescMobileBatteryA", "4DescMobileBatteryB", "4DescMobileBatteryC", "4DescMobileBatteryD", "4DescMobileBatteryE"};
    String[] MobileBatteryDescriptionFifth = {"5DescMobileBatteryA", "5DescMobileBatteryB", "5DescMobileBatteryC", "5DescMobileBatteryD", "5DescMobileBatteryE"};

    //Array for the Men's Fashion Description
    String[] MensFashionDescriptionFirst = {"1DescMensFashionA", "1DescMensFashionB", "1DescMensFashionC", "1DescMensFashionD", "1DescMensFashionE"};
    String[] MensFashionDescriptionSecond = {"2DescMensFashionA", "2DescMensFashionB", "2DescMensFashionC", "2DescMensFashionD", "2DescMensFashionE"};
    String[] MensFashionDescriptionThird = {"3DescMensFashionA", "3DescMensFashionB", "3DescMensFashionC", "3DescMensFashionD", "3DescMensFashionE"};
    String[] MensFashionDescriptionFourth = {"4DescMensFashionA", "4DescMensFashionB", "41DescMensFashionC", "4DescMensFashionD", "4DescMensFashionE"};
    String[] MensFashionDescriptionFifth = {"5DescMensFashionA", "5DescMensFashionB", "5DescMensFashionC", "5DescMensFashionD", "5DescMensFashionE"};

    //Array for the Motherboard Description
    String[] MotherboardDescriptionFirst = {"1DescMotherboardA", "1DescMotherboardB", "1DescMotherboardC", "1DescMotherboardD", "1DescMotherboardE"};
    String[] MotherboardDescriptionSecond = {"2DescMotherboardA", "2DescMotherboardB", "2DescMotherboardC", "2DescMotherboardD", "2DescMotherboardE"};
    String[] MotherboardDescriptionThird = {"3DescMotherboardA", "3DescMotherboardB", "3DescMotherboardC", "3DescMotherboardD", "3DescMotherboardE"};
    String[] MotherboardDescriptionFourth = {"4DescMotherboardA", "4DescMotherboardB", "4DescMotherboardC", "4DescMotherboardD", "4DescMotherboardE"};
    String[] MotherboardDescriptionFifth = {"5DescMotherboardA", "5DescMotherboardB", "5DescMotherboardC", "5DescMotherboardD", "5DescMotherboardE"};

    //Array for the Mouse Description
    String[] MouseDescriptionFirst = {"1DescMouseA", "1DescMouseB", "1DescMouseC", "1DescMouseD", "1DescMouseE"};
    String[] MouseDescriptionSecond = {"2DescMouseA", "2DescMouseB", "2DescMouseC", "2DescMouseD", "2DescMouseE"};
    String[] MouseDescriptionThird = {"3DescMouseA", "3DescMouseB", "3DescMouseC", "3DescMouseD", "3DescMouseE"};
    String[] MouseDescriptionFourth = {"4DescMouseA", "4DescMouseB", "4DescMouseC", "4DescMouseD", "4DescMouseE"};
    String[] MouseDescriptionFifth = {"5DescMouseA", "5DescMouseB", "5DescMouseC", "5DescMouseD", "5DescMouseE"};

    //Array for the Movies CDs Description
    String[] MoviesCDsDescriptionFirst = {"1DescMoviesCDsA", "1DescMoviesCDsB", "1DescMoviesCDsC", "1DescMoviesCDsD", "1DescMoviesCDsE"};
    String[] MoviesCDsDescriptionSecond = {"2DescMoviesCDsA", "2DescMoviesCDsB", "2DescMoviesCDsC", "2DescMoviesCDsD", "2DescMoviesCDsE"};
    String[] MoviesCDsDescriptionThird = {"3DescMoviesCDsA", "3DescMoviesCDsB", "3DescMoviesCDsC", "3DescMoviesCDsD", "3DescMoviesCDsE"};
    String[] MoviesCDsDescriptionFourth = {"4DescMoviesCDsA", "4DescMoviesCDsB", "4DescMoviesCDsC", "4DescMoviesCDsD", "4DescMoviesCDsE"};
    String[] MoviesCDsDescriptionFifth = {"5DescMoviesCDsA", "5DescMoviesCDsB", "5DescMoviesCDsC", "5DescMoviesCDsD", "5DescMoviesCDsE"};

    //Array for the Music CDs Description
    String[] MusicCDsDescriptionFirst = {"1DescMusicCDsA", "1DescMusicCDsB", "1DescMusicCDsC", "1DescMusicCDsD", "1DescMusicCDsE"};
    String[] MusicCDsDescriptionSecond = {"2DescMusicCDsA", "2DescMusicCDsB", "2DescMusicCDsC", "2DescMusicCDsD", "2DescMusicCDsE"};
    String[] MusicCDsDescriptionThird = {"3DescMusicCDsA", "3DescMusicCDsB", "3DescMusicCDsC", "3DescMusicCDsD", "3DescMusicCDsE"};
    String[] MusicCDsDescriptionFourth = {"4DescMusicCDsA", "4DescMusicCDsB", "4DescMusicCDsC", "4DescMusicCDsD", "4DescMusicCDsE"};
    String[] MusicCDsDescriptionFifth = {"5DescMusicCDsA", "5DescMusicCDsB", "5DescMusicCDsC", "5DescMusicCDsD", "5DescMusicCDsE"};

    //Array for the Movies DVDs Description
    String[] MoviesDVDsDescriptionFirst = {"1DescMoviesDVDsA", "1DescMoviesDVDsB", "1DescMoviesDVDsC", "1DescMoviesDVDsD", "1DescMoviesDVDsE"};
    String[] MoviesDVDsDescriptionSecond = {"2DescMoviesDVDsA", "2DescMoviesDVDsB", "2DescMoviesDVDsC", "2DescMoviesDVDsD", "2DescMoviesDVDsE"};
    String[] MoviesDVDsDescriptionThird = {"3DescMoviesDVDsA", "3DescMoviesDVDsB", "3DescMoviesDVDsC", "3DescMoviesDVDsD", "3DescMoviesDVDsE"};
    String[] MoviesDVDsDescriptionFourth = {"4DescMoviesDVDsA", "4DescMoviesDVDsB", "4DescMoviesDVDsC", "4DescMoviesDVDsD", "4DescMoviesDVDsE"};
    String[] MoviesDVDsDescriptionFifth = {"5DescMoviesDVDsA", "5DescMoviesDVDsB", "5DescMoviesDVDsC", "5DescMoviesDVDsD", "5DescMoviesDVDsE"};

    //Array for the Music DVDs Description
    String[] MusicDVDsDescriptionFirst = {"1DescMusicDVDsA", "1DescMusicDVDsB", "1DescMusicDVDsC", "1DescMusicDVDsD", "1DescMusicDVDsE"};
    String[] MusicDVDsDescriptionSecond = {"2DescMusicDVDsA", "2DescMusicDVDsB", "2DescMusicDVDsC", "2DescMusicDVDsD", "2DescMusicDVDsE"};
    String[] MusicDVDsDescriptionThird = {"3DescMusicDVDsA", "3DescMusicDVDsB", "3DescMusicDVDsC", "3DescMusicDVDsD", "3DescMusicDVDsE"};
    String[] MusicDVDsDescriptionFourth = {"4DescMusicDVDsA", "4DescMusicDVDsB", "4DescMusicDVDsC", "4DescMusicDVDsD", "4DescMusicDVDsE"};
    String[] MusicDVDsDescriptionFifth = {"5DescMusicDVDsA", "5DescMusicDVDsB", "5DescMusicDVDsC", "5DescMusicDVDsD", "5DescMusicDVDsE"};

    //Array for the Note Books Description
    String[] NoteBooksDescriptionFirst = {"1DescNoteBooksA", "1DescNoteBooksB", "1DescNoteBooksC", "1DescNoteBooksD", "1DescNoteBooksE"};
    String[] NoteBooksDescriptionSecond = {"2DescNoteBooksA", "2DescNoteBooksB", "2DescNoteBooksC", "2DescNoteBooksD", "2DescNoteBooksE"};
    String[] NoteBooksDescriptionThird = {"3DescNoteBooksA", "3DescNoteBooksB", "3DescNoteBooksC", "3DescNoteBooksD", "3DescNoteBooksE"};
    String[] NoteBooksDescriptionFourth = {"4DescNoteBooksA", "4DescNoteBooksB", "4DescNoteBooksC", "4DescNoteBooksD", "4DescNoteBooksE"};
    String[] NoteBooksDescriptionFifth = {"5DescNoteBooksA", "5DescNoteBooksB", "5DescNoteBooksC", "5DescNoteBooksD", "5DescNoteBooksE"};

    //Array for the Other Books Description
    String[] OtherBooksDescriptionFirst = {"1DescOtherBooksA", "1DescOtherBooksB", "1DescOtherBooksC", "1DescOtherBooksD", "1DescOtherBooksE"};
    String[] OtherBooksDescriptionSecond = {"2DescOtherBooksA", "2DescOtherBooksB", "2DescOtherBooksC", "2DescOtherBooksD", "2DescOtherBooksE"};
    String[] OtherBooksDescriptionThird = {"3DescOtherBooksA", "3DescOtherBooksB", "3DescOtherBooksC", "3DescOtherBooksD", "3DescOtherBooksE"};
    String[] OtherBooksDescriptionFourth = {"4DescOtherBooksA", "4DescOtherBooksB", "4DescOtherBooksC", "4DescOtherBooksD", "4DescOtherBooksE"};
    String[] OtherBooksDescriptionFifth = {"5DescOtherBooksA", "5DescOtherBooksB", "5DescOtherBooksC", "5DescOtherBooksD", "5DescOtherBooksE"};

    //Array for the Oven Description
    String[] OvenDescriptionFirst = {"1DescOvenA", "1DescOvenB", "1DescOvenC", "1DescOvenD", "1DescOvenE"};
    String[] OvenDescriptionSecond = {"2DescOvenA", "2DescOvenB", "2DescOvenC", "2DescOvenD", "2DescOvenE"};
    String[] OvenDescriptionThird = {"3DescOvenA", "3DescOvenB", "3DescOvenC", "3DescOvenD", "3DescOvenE"};
    String[] OvenDescriptionFourth = {"4DescOvenA", "4DescOvenB", "4DescOvenC", "4DescOvenD", "4DescOvenE"};
    String[] OvenDescriptionFifth = {"5DescOvenA", "5DescOvenB", "5DescOvenC", "5DescOvenD", "5DescOvenE"};

    //Array for the Pen Drive Description
    String[] PenDriveDescriptionFirst = {"1DescPenDriveA", "1DescPenDriveB", "1DescPenDriveC", "1DescPenDriveD", "1DescPenDriveE"};
    String[] PenDriveDescriptionSecond = {"2DescPenDriveA", "2DescPenDriveB", "2DescPenDriveC", "2DescPenDriveD", "2DescPenDriveE"};
    String[] PenDriveDescriptionThird = {"3DescPenDriveA", "3DescPenDriveB", "3DescPenDriveC", "3DescPenDriveD", "3DescPenDriveE"};
    String[] PenDriveDescriptionFourth = {"4DescPenDriveA", "4DescPenDriveB", "4DescPenDriveC", "4DescPenDriveD", "4DescPenDriveE"};
    String[] PenDriveDescriptionFifth = {"5DescPenDriveA", "5DescPenDriveB", "5DescPenDriveC", "5DescPenDriveD", "5DescPenDriveE"};

    //Array for the Pens Description
    String[] PensDescriptionFirst = {"1DescPensA", "1DescPensB", "1DescPensC", "1DescPensD", "1DescPensE"};
    String[] PensDescriptionSecond = {"2DescPensA", "2DescPensB", "2DescPensC", "2DescPensD", "2DescPensE"};
    String[] PensDescriptionThird = {"3DescPensA", "3DescPensB", "3DescPensC", "3DescPensD", "3DescPensE"};
    String[] PensDescriptionFourth = {"4DescPensA", "4DescPensB", "4DescPensC", "4DescPensD", "4DescPensE"};
    String[] PensDescriptionFifth = {"5DescPensA", "5DescPensB", "5DescPensC", "5DescPensD", "5DescPensE"};

    //Array for the Refrigerator Description
    String[] RefrigeratorDescriptionFirst = {"1DescDescRefrigeratorA", "1DescDescRefrigeratorB", "1DescDescRefrigeratorC", "1DescDescRefrigeratorD", "1DescDescRefrigeratorE"};
    String[] RefrigeratorDescriptionSecond = {"2DescDescRefrigeratorA", "2DescDescRefrigeratorB", "2DescDescRefrigeratorC", "2DescDescRefrigeratorD", "2DescDescRefrigeratorE"};
    String[] RefrigeratorDescriptionThird = {"3DescDescRefrigeratorA", "3DescDescRefrigeratorB", "3DescDescRefrigeratorC", "3DescDescRefrigeratorD", "3DescDescRefrigeratorE"};
    String[] RefrigeratorDescriptionFourth = {"4DescDescRefrigeratorA", "4DescDescRefrigeratorB", "4DescDescRefrigeratorC", "4DescDescRefrigeratorD", "4DescDescRefrigeratorE"};
    String[] RefrigeratorDescriptionFifth = {"5DescDescRefrigeratorA", "5DescDescRefrigeratorB", "5DescDescRefrigeratorC", "5DescDescRefrigeratorD", "5DescDescRefrigeratorE"};

    //Array for the Smart Watches Description
    String[] SmartWatchesDescriptionFirst = {"1DescDescSmartWatchesA", "1DescDescSmartWatchesB", "1DescDescSmartWatchesC", "1DescDescSmartWatchesD", "1DescDescSmartWatchesE"};
    String[] SmartWatchesDescriptionSecond = {"2DescDescSmartWatchesA", "2DescDescSmartWatchesB", "2DescDescSmartWatchesC", "2DescDescSmartWatchesD", "2DescDescSmartWatchesE"};
    String[] SmartWatchesDescriptionThird = {"3DescDescSmartWatchesA", "3DescDescSmartWatchesB", "3DescDescSmartWatchesC", "3DescDescSmartWatchesD", "3DescDescSmartWatchesE"};
    String[] SmartWatchesDescriptionFourth = {"4DescDescSmartWatchesA", "4DescDescSmartWatchesB", "4DescDescSmartWatchesC", "4DescDescSmartWatchesD", "4DescDescSmartWatchesE"};
    String[] SmartWatchesDescriptionFifth = {"5DescDescSmartWatchesA", "5DescDescSmartWatchesB", "5DescDescSmartWatchesC", "5DescDescSmartWatchesD", "5DescDescSmartWatchesE"};

    //Array for the Speaker Description
    String[] SpeakerDescriptionFirst = {"1DescDescSpeakersA", "1DescDescSpeakersB", "1DescDescSpeakersC", "1DescDescSpeakersD", "1DescDescSpeakersE"};
    String[] SpeakerDescriptionSecond = {"2DescDescSpeakersA", "2DescDescSpeakersB", "2DescDescSpeakersC", "2DescDescSpeakersD", "2DescDescSpeakersE"};
    String[] SpeakerDescriptionThird = {"3DescDescSpeakersA", "3DescDescSpeakersB", "3DescDescSpeakersC", "3DescDescSpeakersD", "3DescDescSpeakersE"};
    String[] SpeakerDescriptionForth = {"4DescDescSpeakersA", "4DescDescSpeakersB", "4DescDescSpeakersC", "4DescDescSpeakersD", "4DescDescSpeakersE"};
    String[] SpeakerDescriptionFifth = {"5DescDescSpeakersA", "5DescDescSpeakersB", "5DescDescSpeakersC", "5DescDescSpeakersD", "5DescDescSpeakersE"};

    //Array for the Sports Shoes Description
    String[] SportsShoesDescriptionFirst = {"1DescDescSportsShoesA", "1DescDescSportsShoesB", "1DescDescSportsShoesC", "1DescDescSportsShoesD", "1DescDescSportsShoesE"};
    String[] SportsShoesDescriptionSecond = {"2DescDescSportsShoesA", "2DescDescSportsShoesB", "2DescDescSportsShoesC", "2DescDescSportsShoesD", "2DescDescSportsShoesE"};
    String[] SportsShoesDescriptionThird = {"3DescDescSportsShoesA", "3DescDescSportsShoesB", "3DescDescSportsShoesC", "3DescDescSportsShoesD", "3DescDescSportsShoesE"};
    String[] SportsShoesDescriptionFourth = {"4DescDescSportsShoesA", "4DescDescSportsShoesB", "4DescDescSportsShoesC", "4DescDescSportsShoesD", "4DescDescSportsShoesE"};
    String[] SportsShoesDescriptionFifth = {"5DescDescSportsShoesA", "5DescDescSportsShoesB", "5DescDescSportsShoesC", "5DescDescSportsShoesD", "5DescDescSportsShoesE"};

    //Array for the Shoes Description
    String[] ShoesDescriptionFirst = {"1DescDescShoesA", "1DescDescShoesB", "1DescDescShoesC", "1DescDescShoesD", "1DescDescShoesE"};
    String[] ShoesDescriptionSecond = {"2DescDescShoesA", "2DescDescShoesB", "2DescDescShoesC", "2DescDescShoesD", "2DescDescShoesE"};
    String[] ShoesDescriptionThird = {"3DescDescShoesA", "3DescDescShoesB", "3DescDescShoesC", "3DescDescShoesD", "3DescDescShoesE"};
    String[] ShoesDescriptionFourth = {"4DescDescShoesA", "4DescDescShoesB", "4DescDescShoesC", "4DescDescShoesD", "4DescDescShoesE"};
    String[] ShoesDescriptionFifth = {"5DescDescShoesA", "5DescDescShoesB", "5DescDescShoesC", "5DescDescShoesD", "5DescDescShoesE"};

    //Array for the Sandal Description
    String[] SandalsDescriptionFirst = {"1DescDescSandalA", "1DescDescSandalB", "1DescDescSandalC", "1DescDescSandalD", "1DescDescSandalE"};
    String[] SandalsDescriptionSecond = {"2DescDescSandalA", "2DescDescSandalB", "2DescDescSandalC", "2DescDescSandalD", "2DescDescSandalE"};
    String[] SandalsDescriptionThird = {"3DescDescSandalA", "3DescDescSandalB", "3DescDescSandalC", "3DescDescSandalD", "3DescDescSandalE"};
    String[] SandalsDescriptionFourth = {"4DescDescSandalA", "4DescDescSandalB", "4DescDescSandalC", "4DescDescSandalD", "4DescDescSandalE"};
    String[] SandalsDescriptionFifth = {"5DescDescSandalA", "5DescDescSandalB", "5DescDescSandalC", "5DescDescSandalD", "5DescDescSandalE"};

    //Array for the Slippers Description
    String[] SlippersDescriptionFirst = {"1DescDescSlippersA", "1DescDescSlippersB", "1DescDescSlippersC", "1DescDescSlippersD", "1DescDescSlippersE"};
    String[] SlippersDescriptionSecond = {"2DescDescSlippersA", "2DescDescSlippersB", "2DescDescSlippersC", "2DescDescSlippersD", "2DescDescSlippersE"};
    String[] SlippersDescriptionThird = {"3DescDescSlippersA", "3DescDescSlippersB", "3DescDescSlippersC", "3DescDescSlippersD", "3DescDescSlippersE"};
    String[] SlippersDescriptionFourth = {"4DescDescSlippersA", "4DescDescSlippersB", "4DescDescSlippersC", "4DescDescSlippersD", "4DescDescSlippersE"};
    String[] SlippersDescriptionFifth = {"5DescDescSlippersA", "5DescDescSlippersB", "5DescDescSlippersC", "5DescDescSlippersD", "5DescDescSlippersE"};

    //Array for the School Bags Description
    String[] SchoolDescriptionFirst = {"1DescDescSchoolBagsA", "1DescDescSchoolBagsB", "1DescDescSchoolBagsC", "1DescDescSchoolBagsD", "1DescDescSchoolBagsE"};
    String[] SchoolDescriptionSecond = {"2DescDescSchoolBagsA", "2DescDescSchoolBagsB", "2DescDescSchoolBagsC", "2DescDescSchoolBagsD", "2DescDescSchoolBagsE"};
    String[] SchoolDescriptionThird = {"3DescDescSchoolBagsA", "3DescDescSchoolBagsB", "3DescDescSchoolBagsC", "3DescDescSchoolBagsD", "3DescDescSchoolBagsE"};
    String[] SchoolDescriptionFourth = {"4DescDescSchoolBagsA", "4DescDescSchoolBagsB", "4DescDescSchoolBagsC", "4DescDescSchoolBagsD", "4DescDescSchoolBagsE"};
    String[] SchoolDescriptionFifth = {"5DescDescSchoolBagsA", "5DescDescSchoolBagsB", "5DescDescSchoolBagsC", "5DescDescSchoolBagsD", "5DescDescSchoolBagsE"};

    //Array for the Tiffin Description
    String[] TiffinDescriptionFirst = {"1DescDescTiffinA", "1DescDescTiffinB", "1DescDescTiffinC", "1DescDescTiffinD", "1DescDescTiffinE"};
    String[] TiffinDescriptionSecond = {"2DescDescTiffinA", "2DescDescTiffinB", "2DescDescTiffinC", "2DescDescTiffinD", "2DescDescTiffinE"};
    String[] TiffinDescriptionThird = {"3DescDescTiffinA", "3DescDescTiffinB", "3DescDescTiffinC", "3DescDescTiffinD", "3DescDescTiffinE"};
    String[] TiffinDescriptionFourth = {"4DescDescTiffinA", "4DescDescTiffinB", "4DescDescTiffinC", "4DescDescTiffinD", "4DescDescTiffinE"};
    String[] TiffinDescriptionFifth = {"5DescDescTiffinA", "5DescDescTiffinB", "5DescDescTiffinC", "5DescDescTiffinD", "5DescDescTiffinE"};

    //Array for the Text Books Description
    String[] TextBooksDescriptionFirst = {"1DescDescTextBooksA", "1DescDescTextBooksB", "1DescDescTextBooksC", "1DescDescTextBooksD", "1DescDescTextBooksE"};
    String[] TextBooksDescriptionSecond = {"2DescDescTextBooksA", "2DescDescTextBooksB", "2DescDescTextBooksC", "2DescDescTextBooksD", "2DescDescTextBooksE"};
    String[] TextBooksDescriptionThird = {"3DescDescTextBooksA", "3DescDescTextBooksB", "3DescDescTextBooksC", "3DescDescTextBooksD", "3DescDescTextBooksE"};
    String[] TextBooksDescriptionFourth = {"4DescDescTextBooksA", "4DescDescTextBooksB", "4DescDescTextBooksC", "4DescDescTextBooksD", "4DescDescTextBooksE"};
    String[] TextBooksDescriptionFifth = {"5DescDescTextBooksA", "5DescDescTextBooksB", "5DescDescTextBooksC", "5DescDescTextBooksD", "5DescDescTextBooksE"};

    //Array for the Women's Fashion Description
    String[] WomensFashionDescriptionFirst = {"1DescDescWomensFashionA", "1DescDescWomensFashionB", "1DescDescWomensFashionC", "1DescDescWomensFashionD", "1DescDescWomensFashionE"};
    String[] WomensFashionDescriptionSecond = {"2DescDescWomensFashionA", "2DescDescWomensFashionB", "2DescDescWomensFashionC", "2DescDescWomensFashionD", "2DescDescWomensFashionE"};
    String[] WomensFashionDescriptionThird = {"3DescDescWomensFashionA", "3DescDescWomensFashionB", "3DescDescWomensFashionC", "3DescDescWomensFashionD", "3DescDescWomensFashionE"};
    String[] WomensFashionDescriptionFourth = {"4DescDescWomensFashionA", "4DescDescWomensFashionB", "4DescDescWomensFashionC", "4DescDescWomensFashionD", "4DescDescWomensFashionE"};
    String[] WomensFashionDescriptionFifth = {"5DescDescWomensFashionA", "5DescDescWomensFashionB", "5DescDescWomensFashionC", "5DescDescWomensFashionD", "5DescDescWomensFashionE"};

    //Array for the Water Bags Description
    String[] WaterBagsDescriptionFirst = {"1DescDescWaterBagsA", "1DescDescWaterBagsB", "1DescDescWaterBagsC", "1DescDescWaterBagsD", "1DescDescWaterBagsE"};
    String[] WaterBagsDescriptionSecond = {"2DescDescWaterBagsA", "2DescDescWaterBagsB", "2DescDescWaterBagsC", "2DescDescWaterBagsD", "2DescDescWaterBagsE"};
    String[] WaterBagsDescriptionThird = {"3DescDescWaterBagsA", "3DescDescWaterBagsB", "3DescDescWaterBagsC", "3DescDescWaterBagsD", "3DescDescWaterBagsE"};
    String[] WaterBagsDescriptionFourth = {"4DescDescWaterBagsA", "4DescDescWaterBagsB", "4DescDescWaterBagsC", "4DescDescWaterBagsD", "4DescDescWaterBagsE"};
    String[] WaterBagsDescriptionFifth = {"5DescDescWaterBagsA", "5DescDescWaterBagsB", "5DescDescWaterBagsC", "5DescDescWaterBagsD", "5DescDescWaterBagsE"};

    //Array for the Webcam Description
    String[] WebcamDescriptionFirst = {"1DescDescWebcamA", "1DescDescWebcamB", "1DescDescWebcamC", "1DescDescWebcamD", "1DescDescWebcamE"};
    String[] WebcamDescriptionSecond = {"2DescDescWebcamA", "2DescDescWebcamB", "2DescDescWebcamC", "2DescDescWebcamD", "2DescDescWebcamE"};
    String[] WebcamDescriptionThird = {"3DescDescWebcamA", "3DescDescWebcamB", "3DescDescWebcamC", "3DescDescWebcamD", "3DescDescWebcamE"};
    String[] WebcamDescriptionFourth = {"4DescDescWebcamA", "4DescDescWebcamB", "4DescDescWebcamC", "4DescDescWebcamD", "4DescDescWebcamE"};
    String[] WebcamDescriptionFifth = {"5DescDescWebcamA", "5DescDescWebcamB", "5DescDescWebcamC", "5DescDescWebcamD", "5DescDescWebcamE"};

    //Array for the Video Games Description
    String[] VideoGamesDescriptionFirst = {"1DescDescVideoGamesA", "1DescDescVideoGamesB", "1DescDescVideoGamesC", "1DescDescVideoGamesD", "1DescDescVideoGamesE"};
    String[] VideoGamesDescriptionSecond = {"2DescDescVideoGamesA", "2DescDescVideoGamesB", "2DescDescVideoGamesC", "2DescDescVideoGamesD", "2DescDescVideoGamesE"};
    String[] VideoGamesDescriptionThird = {"3DescDescVideoGamesA", "3DescDescVideoGamesB", "3DescDescVideoGamesC", "3DescDescVideoGamesD", "3DescDescVideoGamesE"};
    String[] VideoGamesDescriptionFourth = {"4DescDescVideoGamesA", "4DescDescVideoGamesB", "4DescDescVideoGamesC", "4DescDescVideoGamesD", "4DescDescVideoGamesE"};
    String[] VideoGamesDescriptionFifth = {"5DescDescVideoGamesA", "5DescDescVideoGamesB", "5DescDescVideoGamesC", "5DescDescVideoGamesD", "5DescDescVideoGamesE"};

    //Array for the Teddy Bear Description
    String[] TeddyBearDescriptionFirst = {"1DescDescTeddyBearA", "1DescDescTeddyBearB", "1DescDescTeddyBearC", "1DescDescTeddyBearD", "1DescDescTeddyBearE"};
    String[] TeddyBearDescriptionSecond = {"2DescDescTeddyBearA", "2DescDescTeddyBearB", "2DescDescTeddyBearC", "2DescDescTeddyBearD", "2DescDescTeddyBearE"};
    String[] TeddyBearDescriptionThird = {"3DescDescTeddyBearA", "3DescDescTeddyBearB", "3DescDescTeddyBearC", "3DescDescTeddyBearD", "3DescDescTeddyBearE"};
    String[] TeddyBearDescriptionFourth = {"4DescDescTeddyBearA", "4DescDescTeddyBearB", "4DescDescTeddyBearC", "4DescDescTeddyBearD", "4DescDescTeddyBearE"};
    String[] TeddyBearDescriptionFifth = {"5DescDescTeddyBearA", "5DescDescTeddyBearB", "5DescDescTeddyBearC", "51DescDescTeddyBearD", "5DescDescTeddyBearE"};

    //Array for the Television Description
    String[] TelevisionDescriptionFirst = {"1DescDescTelevisionA", "1DescDescTelevisionB", "1DescDescTelevisionC", "1DescDescTelevisionD", "1DescDescTelevisionE"};
    String[] TelevisionDescriptionSecond = {"2DescDescTelevisionA", "2DescDescTelevisionB", "2DescDescTelevisionC", "2DescDescTelevisionD", "2DescDescTelevisionE"};
    String[] TelevisionDescriptionThird = {"3DescDescTelevisionA", "3DescDescTelevisionB", "3DescDescTelevisionC", "3DescDescTelevisionD", "3DescDescTelevisionE"};
    String[] TelevisionDescriptionFourth = {"4DescDescTelevisionA", "4DescDescTelevisionB", "4DescDescTelevisionC", "4DescDescTelevisionD", "4DescDescTelevisionE"};
    String[] TelevisionDescriptionFifth = {"5DescDescTelevisionA", "5DescDescTelevisionB", "5DescDescTelevisionC", "5DescDescTelevisionD", "5DescDescTelevisionE"};

    //Array for the Tablets Description
    String[] TabletsDescriptionFirst = {"1DescDescTabletsA", "1DescDescTabletsB", "1DescDescTabletsC", "1DescDescTabletsD", "1DescDescTabletsE"};
    String[] TabletsDescriptionSecond = {"2DescDescTabletsA", "2DescDescTabletsB", "2DescDescTabletsC", "2DescDescTabletsD", "2DescDescTabletsE"};
    String[] TabletsDescriptionThird = {"3DescDescTabletsA", "3DescDescTabletsB", "3DescDescTabletsC", "3DescDescTabletsD", "3DescDescTabletsE"};
    String[] TabletsDescriptionFourth = {"4DescDescTabletsA", "4DescDescTabletsB", "4DescDescTabletsC", "4DescDescTabletsD", "4DescDescTabletsE"};
    String[] TabletsDescriptionFifth = {"5DescDescTabletsA", "5DescDescTabletsB", "5DescDescTabletsC", "5DescDescTabletsD", "5DescDescTabletsE"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discription_of_item);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        textViewDescriptionOne = (TextView) findViewById(R.id.textViewDescriptionOne);
        textViewDescriptionTwo = (TextView) findViewById(R.id.textViewDescriptionTwo);
        textViewDescriptionThree = (TextView) findViewById(R.id.textViewDescriptionThree);
        textViewDescriptionFour = (TextView) findViewById(R.id.textViewDescriptionFour);
        textViewDescriptionFive = (TextView) findViewById(R.id.textViewDescriptionFive);

        spinnerDescriptionOne = (Spinner) findViewById(R.id.spinnerDescriptionOne);
        spinnerDescriptionTwo = (Spinner) findViewById(R.id.spinnerDescriptionTwo);
        spinnerDescriptionThree = (Spinner) findViewById(R.id.spinnerDescriptionThree);
        spinnerDescriptionFour = (Spinner) findViewById(R.id.spinnerDescriptionFour);
        spinnerDescriptionFive = (Spinner) findViewById(R.id.spinnerDescriptionFive);

        final String nameR, usernameR, mobileR, areaR, priceR;

        nameR = getIntent().getStringExtra("name");
        usernameR = getIntent().getStringExtra("username");
        mobileR = getIntent().getStringExtra("mobile");
        areaR = getIntent().getStringExtra("area");
        priceR = getIntent().getStringExtra("price");

        buttonSubmitInDescriptionActivity = (Button) findViewById(R.id.buttonSubmitInDescriptionActivity);
        buttonCheckDescriptionInDescriptionActivity = (Button) findViewById(R.id.buttonCheckDescriptionInDescriptionActivity);
        textViewOfFullDescription = (TextView) findViewById(R.id.textViewOfFullDescription);

        gettingValueTypeOfItem = getIntent().getStringExtra("Type of the Item");
        settingValuesToDiscriptionActivity();

        buttonCheckDescriptionInDescriptionActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                textFromSpinnerDescriptionOne = spinnerDescriptionOne.getSelectedItem().toString();
                textFromSpinnerDescriptionTwo = spinnerDescriptionTwo.getSelectedItem().toString();
                textFromSpinnerDescriptionThree = spinnerDescriptionThree.getSelectedItem().toString();
                textFromSpinnerDescriptionFour = spinnerDescriptionFour.getSelectedItem().toString();
                textFromSpinnerDescriptionFive = spinnerDescriptionFive.getSelectedItem().toString();


                if (textFromSpinnerDescriptionOne.equals("SELECT") || textFromSpinnerDescriptionTwo.equals("SELECT") ||
                        textFromSpinnerDescriptionThree.equals("SELECT") || textFromSpinnerDescriptionFour.equals("SELECT") ||
                        textFromSpinnerDescriptionFive.equals("SELECT")) {

                    Toast.makeText(DiscriptionOfItemActivity.this, "Please fill up all the fields", Toast.LENGTH_SHORT).show();

                } else {

                    allDescriptionContentString = (
                            textViewDescriptionOne.getText().toString() +"  :=  "+ textFromSpinnerDescriptionOne +",  \n"+
                                    textViewDescriptionTwo.getText().toString() +"  :=  "+ textFromSpinnerDescriptionTwo +",  \n"+
                                    textViewDescriptionThree.getText().toString() +"  :=  "+ textFromSpinnerDescriptionThree +",  \n"+
                                    textViewDescriptionFour.getText().toString() +"  :=  "+ textFromSpinnerDescriptionFour +",  \n"+
                                    textViewDescriptionFive.getText().toString() +"  :=  "+ textFromSpinnerDescriptionFive);

                    textViewOfFullDescription.setText(allDescriptionContentString);

                }

            }
        });

        buttonSubmitInDescriptionActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (textViewOfFullDescription.getText().toString().equals("")) {
                    Toast.makeText(DiscriptionOfItemActivity.this, "First Check all description by clicking on check description button",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(DiscriptionOfItemActivity.this, AddItemActivity.class);
                    intent.putExtra("Description Of Item", textViewOfFullDescription.getText().toString());
                    intent.putExtra("nameOfI",nameR);
                    intent.putExtra("usernameOfI",usernameR);
                    intent.putExtra("mobileOfI",mobileR);
                    intent.putExtra("priceOfI",priceR);
                    intent.putExtra("areaOfI",areaR);
                    startActivity(intent);
                }
            }
        });

    }

    @SuppressLint("SetTextI18n")
    private void settingValuesToDiscriptionActivity() {

        if (gettingValueTypeOfItem.equals("Barbie")){

            textViewDescriptionOne.setText(setText1DescBarbie);
            textViewDescriptionTwo.setText(setText2DescBarbie);
            textViewDescriptionThree.setText(setText3DescBarbie);
            textViewDescriptionFour.setText(R.string.setText4DescBarbie);
            textViewDescriptionFive.setText(R.string.setText5DescBarbie);

            spinnerDescriptionOne.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, BarbieDescriptionFirst));
            spinnerDescriptionTwo.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, BarbieDescriptionSecond));
            spinnerDescriptionThree.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, BarbieDescriptionThird));
            spinnerDescriptionFour.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, BarbieDescriptionFourth));
            spinnerDescriptionFive.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, BarbieDescriptionFifth));

        }

        if (gettingValueTypeOfItem.equals("Bluetooth")){

            textViewDescriptionOne.setText(R.string.setText1DescBluetooth);
            textViewDescriptionTwo.setText(R.string.setText2DescBluetooth);
            textViewDescriptionThree.setText(R.string.setText3DescBluetooth);
            textViewDescriptionFour.setText(R.string.setText4DescBluetooth);
            textViewDescriptionFive.setText(R.string.setText5DescBluetooth);

            spinnerDescriptionOne.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, BluetoothDescriptionFirst));
            spinnerDescriptionTwo.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, BluetoothDescriptionSecond));
            spinnerDescriptionThree.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, BluetoothDescriptionThird));
            spinnerDescriptionFour.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, BluetoothDescriptionFourth));
            spinnerDescriptionFive.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, BluetoothDescriptionFifth));

        }

        if (gettingValueTypeOfItem.equals("Car Toys")){

            textViewDescriptionOne.setText(R.string.setText1DescCarToys);
            textViewDescriptionTwo.setText(R.string.setText2DescCarToys);
            textViewDescriptionThree.setText(R.string.setText3DescCarToys);
            textViewDescriptionFour.setText(R.string.setText4DescCarToys);
            textViewDescriptionFive.setText(R.string.setText5DescCarToys);

            spinnerDescriptionOne.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, CarToysDescriptionFirst));
            spinnerDescriptionTwo.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, CarToysDescriptionSecond));
            spinnerDescriptionThree.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, CarToysDescriptionThird));
            spinnerDescriptionFour.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, CarToysDescriptionFourth));
            spinnerDescriptionFive.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, CarToysDescriptionFifth));

        }

        if (gettingValueTypeOfItem.equals("Charger")){

            textViewDescriptionOne.setText(R.string.setTex1DescCharger);
            textViewDescriptionTwo.setText(R.string.setTex2DescCharger);
            textViewDescriptionThree.setText(R.string.setTex3DescCharger);
            textViewDescriptionFour.setText(R.string.setTex4DescCharger);
            textViewDescriptionFive.setText(R.string.setTex5DescCharger);

            spinnerDescriptionOne.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, ChargerDescriptionFirst));
            spinnerDescriptionTwo.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, ChargerDescriptionSecond));
            spinnerDescriptionThree.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, ChargerDescriptionThird));
            spinnerDescriptionFour.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, ChargerDescriptionFourth));
            spinnerDescriptionFive.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, ChargerDescriptionFifth));

        }

        if (gettingValueTypeOfItem.equals("Children's Books")){

            textViewDescriptionOne.setText(R.string.setText1DescChildrensBooks);
            textViewDescriptionTwo.setText(R.string.setText2DescChildrensBooks);
            textViewDescriptionThree.setText(R.string.setText3DescChildrensBooks);
            textViewDescriptionFour.setText(R.string.setText4DescChildrensBooks);
            textViewDescriptionFive.setText(R.string.setText5DescChildrensBooks);

            spinnerDescriptionOne.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, ChildrensBooksDescriptionFirst));
            spinnerDescriptionTwo.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, ChildrensBooksDescriptionSecond));
            spinnerDescriptionThree.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, ChildrensBooksDescriptionThird));
            spinnerDescriptionFour.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, ChildrensBooksDescriptionFourth));
            spinnerDescriptionFive.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, ChildrensBooksDescriptionFifth));

        }

        if (gettingValueTypeOfItem.equals("Computer")){

            textViewDescriptionOne.setText(R.string.setText1DescComputer);
            textViewDescriptionTwo.setText(R.string.setText2DescComputer);
            textViewDescriptionThree.setText(R.string.setText3DescComputer);
            textViewDescriptionFour.setText(R.string.setText4DescComputer);
            textViewDescriptionFive.setText(R.string.setText5DescComputer);

            spinnerDescriptionOne.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, ComputerBooksDescriptionFirst));
            spinnerDescriptionTwo.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, ComputerBooksDescriptionSecond));
            spinnerDescriptionThree.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, ComputerBooksDescriptionThird));
            spinnerDescriptionFour.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, ComputerBooksDescriptionFourth));
            spinnerDescriptionFive.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, ComputerBooksDescriptionFifth));

        }

        if (gettingValueTypeOfItem.equals("Children's Fashion")){

            textViewDescriptionOne.setText(R.string.setText1DescChildrensFashion);
            textViewDescriptionTwo.setText(R.string.setText2DescChildrensFashion);
            textViewDescriptionThree.setText(R.string.setText3DescChildrensFashion);
            textViewDescriptionFour.setText(R.string.setText4DescChildrensFashion);
            textViewDescriptionFive.setText(R.string.setText5DescChildrensFashion);

            spinnerDescriptionOne.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, ChildrensFashionDescriptionFirst));
            spinnerDescriptionTwo.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, ChildrensFashionDescriptionSecond));
            spinnerDescriptionThree.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, ChildrensFashionDescriptionThird));
            spinnerDescriptionFour.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, ChildrensFashionDescriptionFourth));
            spinnerDescriptionFive.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, ChildrensFashionDescriptionFifth));

        }

        if (gettingValueTypeOfItem.equals("Fan")){

            textViewDescriptionOne.setText(R.string.setTex1DescFan);
            textViewDescriptionTwo.setText(R.string.setTex2DescFan);
            textViewDescriptionThree.setText(R.string.setTex3DescFan);
            textViewDescriptionFour.setText(R.string.setTex4DescFan);
            textViewDescriptionFive.setText(R.string.setTex5DescFan);

            spinnerDescriptionOne.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, FanDescriptionFirst));
            spinnerDescriptionTwo.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, FanDescriptionSecond));
            spinnerDescriptionThree.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, FanDescriptionThird));
            spinnerDescriptionFour.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, FanDescriptionFourth));
            spinnerDescriptionFive.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, FanDescriptionFifth));

        }

        if (gettingValueTypeOfItem.equals("Gents Watches")){

            textViewDescriptionOne.setText(R.string.setTex1DescGentsWatches);
            textViewDescriptionTwo.setText(R.string.setTex2DescGentsWatches);
            textViewDescriptionThree.setText(R.string.setTex3DescGentsWatches);
            textViewDescriptionFour.setText(R.string.setTex4DescGentsWatches);
            textViewDescriptionFive.setText(R.string.setTex5DescGentsWatches);

            spinnerDescriptionOne.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, GentsWatchesDescriptionFirst));
            spinnerDescriptionTwo.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, GentsWatchesDescriptionSecond));
            spinnerDescriptionThree.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, GentsWatchesDescriptionThird));
            spinnerDescriptionFour.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, GentsWatchesDescriptionFourth));
            spinnerDescriptionFive.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, GentsWatchesDescriptionFifth));

        }

        if (gettingValueTypeOfItem.equals("Headsets")){

            textViewDescriptionOne.setText(R.string.setTex1DescHeadsets);
            textViewDescriptionTwo.setText(R.string.setTex2DescHeadsets);
            textViewDescriptionThree.setText(R.string.setTex3DescHeadsets);
            textViewDescriptionFour.setText(R.string.setTex4DescHeadsets);
            textViewDescriptionFive.setText(R.string.setTex5DescHeadsets);

            spinnerDescriptionOne.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, HeadsetsDescriptionFirst));
            spinnerDescriptionTwo.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, HeadsetsDescriptionSecond));
            spinnerDescriptionThree.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, HeadsetsDescriptionThird));
            spinnerDescriptionFour.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, HeadsetsDescriptionFourth));
            spinnerDescriptionFive.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, HeadsetsDescriptionFifth));

        }

        if (gettingValueTypeOfItem.equals("Headphones")){

            textViewDescriptionOne.setText(R.string.setTex1DescHeadphones);
            textViewDescriptionTwo.setText(R.string.setTex2DescHeadphones);
            textViewDescriptionThree.setText(R.string.setTex3DescHeadphones);
            textViewDescriptionFour.setText(R.string.setTex4DescHeadphones);
            textViewDescriptionFive.setText(R.string.setTex5DescHeadphones);

            spinnerDescriptionOne.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, HeadphonesDescriptionFirst));
            spinnerDescriptionTwo.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, HeadphonesDescriptionSecond));
            spinnerDescriptionThree.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, HeadphonesDescriptionThird));
            spinnerDescriptionFour.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, HeadphonesDescriptionFourth));
            spinnerDescriptionFive.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, HeadphonesDescriptionFifth));

        }

        if (gettingValueTypeOfItem.equals("Home Theater")){

            textViewDescriptionOne.setText(R.string.setTex1DescHomeTheater);
            textViewDescriptionTwo.setText(R.string.setTex2DescHomeTheater);
            textViewDescriptionThree.setText(R.string.setTex3DescHomeTheater);
            textViewDescriptionFour.setText(R.string.setTex4DescHomeTheater);
            textViewDescriptionFive.setText(R.string.setTex5DescHomeTheater);

            spinnerDescriptionOne.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, HomeTheaterDescriptionFirst));
            spinnerDescriptionTwo.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, HomeTheaterDescriptionSecond));
            spinnerDescriptionThree.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, HomeTheaterDescriptionThird));
            spinnerDescriptionFour.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, HomeTheaterDescriptionFourth));
            spinnerDescriptionFive.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, HomeTheaterDescriptionFifth));

        }

        if (gettingValueTypeOfItem.equals("Hard Disks")){

            textViewDescriptionOne.setText(R.string.setTex1DescHardDisks);
            textViewDescriptionTwo.setText(R.string.setTex2DescHardDisks);
            textViewDescriptionThree.setText(R.string.setTex3DescHardDisks);
            textViewDescriptionFour.setText(R.string.setTex4DescHardDisks);
            textViewDescriptionFive.setText(R.string.setTex5DescHardDisks);

            spinnerDescriptionOne.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, HardDisksDescriptionFirst));
            spinnerDescriptionTwo.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, HardDisksDescriptionSecond));
            spinnerDescriptionThree.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, HardDisksDescriptionThird));
            spinnerDescriptionFour.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, HardDisksDescriptionFourth));
            spinnerDescriptionFive.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, HardDisksDescriptionFifth));

        }

        if (gettingValueTypeOfItem.equals("Keyboard")){

            textViewDescriptionOne.setText("setTex1DescKeyboard");
            textViewDescriptionTwo.setText("setTex1DescKeyboard");
            textViewDescriptionThree.setText("setTex1DescKeyboard");
            textViewDescriptionFour.setText("setTex1DescKeyboard");
            textViewDescriptionFive.setText("setTex1DescKeyboard");

            spinnerDescriptionOne.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, KeyboardDescriptionFirst));
            spinnerDescriptionTwo.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, KeyboardDescriptionSecond));
            spinnerDescriptionThree.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, KeyboardDescriptionThird));
            spinnerDescriptionFour.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, KeyboardDescriptionFourth));
            spinnerDescriptionFive.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, KeyboardDescriptionFifth));

        }

        if (gettingValueTypeOfItem.equals("Laptop")){

            textViewDescriptionOne.setText("setTex1DescLaptop");
            textViewDescriptionTwo.setText("setTex2DescLaptop");
            textViewDescriptionThree.setText("setTex3DescLaptop");
            textViewDescriptionFour.setText("setTex4DescLaptop");
            textViewDescriptionFive.setText("setTex5DescLaptop");

            spinnerDescriptionOne.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, LaptopDescriptionFirst));
            spinnerDescriptionTwo.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, LaptopDescriptionSecond));
            spinnerDescriptionThree.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, LaptopDescriptionThird));
            spinnerDescriptionFour.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, LaptopDescriptionFourth));
            spinnerDescriptionFive.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, LaptopDescriptionFifth));

        }

        if (gettingValueTypeOfItem.equals("Light Bulbs")){

            textViewDescriptionOne.setText("setTex1DescLightBulbs");
            textViewDescriptionTwo.setText("setTex2DescLightBulbs");
            textViewDescriptionThree.setText("setTex3DescLightBulbs");
            textViewDescriptionFour.setText("setTex4DescLightBulbs");
            textViewDescriptionFive.setText("setTex5DescLightBulbs");

            spinnerDescriptionOne.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, LightBulbsDescriptionFirst));
            spinnerDescriptionTwo.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, LightBulbsDescriptionSecond));
            spinnerDescriptionThree.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, LightBulbsDescriptionThird));
            spinnerDescriptionFour.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, LightBulbsDescriptionFourth));
            spinnerDescriptionFive.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, LightBulbsDescriptionFifth));

        }

        if (gettingValueTypeOfItem.equals("Ladies Watches")){

            textViewDescriptionOne.setText("setTex1DescLadiesWatches");
            textViewDescriptionTwo.setText("setTex2DescLadiesWatches");
            textViewDescriptionThree.setText("setTex3DescLadiesWatches");
            textViewDescriptionFour.setText("setTex4DescLadiesWatches");
            textViewDescriptionFive.setText("setTex5DescLadiesWatches");

            spinnerDescriptionOne.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, LadiesWatchesDescriptionFirst));
            spinnerDescriptionTwo.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, LadiesWatchesDescriptionSecond));
            spinnerDescriptionThree.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, LadiesWatchesDescriptionThird));
            spinnerDescriptionFour.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, LadiesWatchesDescriptionFourth));
            spinnerDescriptionFive.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, LadiesWatchesDescriptionFifth));

        }

        if (gettingValueTypeOfItem.equals("Magzines")){

            textViewDescriptionOne.setText("setTex1DescMagzines");
            textViewDescriptionTwo.setText("setTex2DescMagzines");
            textViewDescriptionThree.setText("setTex3DescMagzines");
            textViewDescriptionFour.setText("setTex4DescMagzines");
            textViewDescriptionFive.setText("setTex5DescMagzines");

            spinnerDescriptionOne.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, MagzinesDescriptionFirst));
            spinnerDescriptionTwo.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, MagzinesDescriptionSecond));
            spinnerDescriptionThree.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, MagzinesDescriptionThird));
            spinnerDescriptionFour.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, MagzinesDescriptionFourth));
            spinnerDescriptionFive.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, MagzinesDescriptionFifth));

        }

        if (gettingValueTypeOfItem.equals("Mobiles")){

            textViewDescriptionOne.setText("RAM");
            textViewDescriptionTwo.setText("Android Version");
            textViewDescriptionThree.setText("Processor");
            textViewDescriptionFour.setText("Internal Memory");
            textViewDescriptionFive.setText("setTex5DescMobiles");

            spinnerDescriptionOne.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, MobilesDescriptionFirst));
            spinnerDescriptionTwo.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, MobilesDescriptionSecond));
            spinnerDescriptionThree.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, MobilesDescriptionThird));
            spinnerDescriptionFour.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, MobilesDescriptionFourth));
            spinnerDescriptionFive.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, MobilesDescriptionFifth));

        }

        if (gettingValueTypeOfItem.equals("Mobile Battery")){

            textViewDescriptionOne.setText("setTex1DescMobileBattery");
            textViewDescriptionTwo.setText("setTex2DescMobileBattery");
            textViewDescriptionThree.setText("setTex3DescMobileBattery");
            textViewDescriptionFour.setText("setTex4DescMobileBattery");
            textViewDescriptionFive.setText("setTex5DescMobileBattery");

            spinnerDescriptionOne.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, MobileBatteryDescriptionFirst));
            spinnerDescriptionTwo.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, MobileBatteryDescriptionSecond));
            spinnerDescriptionThree.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, MobileBatteryDescriptionThird));
            spinnerDescriptionFour.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, MobileBatteryDescriptionFourth));
            spinnerDescriptionFive.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, MobileBatteryDescriptionFifth));

        }

        if (gettingValueTypeOfItem.equals("Men's Fashion")){

            textViewDescriptionOne.setText("setTex1DescMensFashion");
            textViewDescriptionTwo.setText("setTex2DescMensFashion");
            textViewDescriptionThree.setText("setTex3DescMensFashion");
            textViewDescriptionFour.setText("setTex4DescMensFashion");
            textViewDescriptionFive.setText("setTex5DescMensFashion");

            spinnerDescriptionOne.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, MensFashionDescriptionFirst));
            spinnerDescriptionTwo.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, MensFashionDescriptionSecond));
            spinnerDescriptionThree.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, MensFashionDescriptionThird));
            spinnerDescriptionFour.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, MensFashionDescriptionFourth));
            spinnerDescriptionFive.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, MensFashionDescriptionFifth));

        }

        if (gettingValueTypeOfItem.equals("Motherboard")){

            textViewDescriptionOne.setText("setTex1DescMotherboard");
            textViewDescriptionTwo.setText("setTex2DescMotherboard");
            textViewDescriptionThree.setText("setTex3DescMotherboard");
            textViewDescriptionFour.setText("setTex4DescMotherboard");
            textViewDescriptionFive.setText("setTex5DescMotherboard");

            spinnerDescriptionOne.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, MotherboardDescriptionFirst));
            spinnerDescriptionTwo.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, MotherboardDescriptionSecond));
            spinnerDescriptionThree.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, MotherboardDescriptionThird));
            spinnerDescriptionFour.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, MotherboardDescriptionFourth));
            spinnerDescriptionFive.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, MotherboardDescriptionFifth));

        }

        if (gettingValueTypeOfItem.equals("Mouse")){

            textViewDescriptionOne.setText("setTex1DescMouse");
            textViewDescriptionTwo.setText("setTex2DescMouse");
            textViewDescriptionThree.setText("setTex3DescMouse");
            textViewDescriptionFour.setText("setTex4DescMouse");
            textViewDescriptionFive.setText("setTex5DescMouse");

            spinnerDescriptionOne.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, MouseDescriptionFirst));
            spinnerDescriptionTwo.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, MouseDescriptionSecond));
            spinnerDescriptionThree.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, MouseDescriptionThird));
            spinnerDescriptionFour.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, MouseDescriptionFourth));
            spinnerDescriptionFive.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, MouseDescriptionFifth));

        }

        if (gettingValueTypeOfItem.equals("Movies CDs")){

            textViewDescriptionOne.setText("setTex1DescMoviesCDs");
            textViewDescriptionTwo.setText("setTex2DescMoviesCDs");
            textViewDescriptionThree.setText("setTex3DescMoviesCDs");
            textViewDescriptionFour.setText("setTex4DescMoviesCDs");
            textViewDescriptionFive.setText("setTex5DescMoviesCDs");

            spinnerDescriptionOne.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, MoviesCDsDescriptionFirst));
            spinnerDescriptionTwo.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, MoviesCDsDescriptionSecond));
            spinnerDescriptionThree.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, MoviesCDsDescriptionThird));
            spinnerDescriptionFour.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, MoviesCDsDescriptionFourth));
            spinnerDescriptionFive.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, MoviesCDsDescriptionFifth));

        }

        if (gettingValueTypeOfItem.equals("Music CDs")){

            textViewDescriptionOne.setText("setTex1DescMusicCDs");
            textViewDescriptionTwo.setText("setTex2DescMusicCDs");
            textViewDescriptionThree.setText("setTex3DescMusicCDs");
            textViewDescriptionFour.setText("setTex4DescMusicCDs");
            textViewDescriptionFive.setText("setTex5DescMusicCDs");

            spinnerDescriptionOne.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, MusicCDsDescriptionFirst));
            spinnerDescriptionTwo.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, MusicCDsDescriptionSecond));
            spinnerDescriptionThree.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, MusicCDsDescriptionThird));
            spinnerDescriptionFour.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, MusicCDsDescriptionFourth));
            spinnerDescriptionFive.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, MusicCDsDescriptionFifth));

        }

        if (gettingValueTypeOfItem.equals("Movies DVDs")){

            textViewDescriptionOne.setText("setTex1DescMoviesDVDs");
            textViewDescriptionTwo.setText("setTex2DescMoviesDVDs");
            textViewDescriptionThree.setText("setTex3DescMoviesDVDs");
            textViewDescriptionFour.setText("setTex4DescMoviesDVDs");
            textViewDescriptionFive.setText("setTex5DescMoviesDVDs");

            spinnerDescriptionOne.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, MoviesDVDsDescriptionFirst));
            spinnerDescriptionTwo.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, MoviesDVDsDescriptionSecond));
            spinnerDescriptionThree.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, MoviesDVDsDescriptionThird));
            spinnerDescriptionFour.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, MoviesDVDsDescriptionFourth));
            spinnerDescriptionFive.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, MoviesDVDsDescriptionFifth));

        }

        if (gettingValueTypeOfItem.equals("Music DVDs")){

            textViewDescriptionOne.setText("setTex1DescMusicDVDs");
            textViewDescriptionTwo.setText("setTex2DescMusicDVDs");
            textViewDescriptionThree.setText("setTex3DescMusicDVDs");
            textViewDescriptionFour.setText("setTex4DescMusicDVDs");
            textViewDescriptionFive.setText("setTex5DescMusicDVDs");

            spinnerDescriptionOne.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, MusicDVDsDescriptionFirst));
            spinnerDescriptionTwo.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, MusicDVDsDescriptionSecond));
            spinnerDescriptionThree.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, MusicDVDsDescriptionThird));
            spinnerDescriptionFour.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, MusicDVDsDescriptionFourth));
            spinnerDescriptionFive.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, MusicDVDsDescriptionFifth));

        }

        if (gettingValueTypeOfItem.equals("Note Books")){

            textViewDescriptionOne.setText("setTex1DescNoteBooks");
            textViewDescriptionTwo.setText("setTex2DescNoteBooks");
            textViewDescriptionThree.setText("setTex3DescNoteBooks");
            textViewDescriptionFour.setText("setTex4DescNoteBooks");
            textViewDescriptionFive.setText("setTex5DescNoteBooks");

            spinnerDescriptionOne.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NoteBooksDescriptionFirst));
            spinnerDescriptionTwo.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NoteBooksDescriptionSecond));
            spinnerDescriptionThree.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NoteBooksDescriptionThird));
            spinnerDescriptionFour.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NoteBooksDescriptionFourth));
            spinnerDescriptionFive.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NoteBooksDescriptionFifth));

        }

        if (gettingValueTypeOfItem.equals("Other Books")){

            textViewDescriptionOne.setText("setTex1DescOtherBooks");
            textViewDescriptionTwo.setText("setTex1DescOtherBooks");
            textViewDescriptionThree.setText("setTex1DescOtherBooks");
            textViewDescriptionFour.setText("setTex1DescOtherBooks");
            textViewDescriptionFive.setText("setTex1DescOtherBooks");

            spinnerDescriptionOne.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, OtherBooksDescriptionFirst));
            spinnerDescriptionTwo.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, OtherBooksDescriptionSecond));
            spinnerDescriptionThree.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, OtherBooksDescriptionThird));
            spinnerDescriptionFour.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, OtherBooksDescriptionFourth));
            spinnerDescriptionFive.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, OtherBooksDescriptionFifth));

        }

        if (gettingValueTypeOfItem.equals("Oven")){

            textViewDescriptionOne.setText("setTex1DescOven");
            textViewDescriptionTwo.setText("setTex2DescOven");
            textViewDescriptionThree.setText("setTex3DescOven");
            textViewDescriptionFour.setText("setTex4DescOven");
            textViewDescriptionFive.setText("setTex5DescOven");

            spinnerDescriptionOne.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, OvenDescriptionFirst));
            spinnerDescriptionTwo.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, OvenDescriptionSecond));
            spinnerDescriptionThree.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, OvenDescriptionThird));
            spinnerDescriptionFour.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, OvenDescriptionFourth));
            spinnerDescriptionFive.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, OvenDescriptionFifth));

        }

        if (gettingValueTypeOfItem.equals("Pen Drive")){

            textViewDescriptionOne.setText("setTex1DescPenDrive");
            textViewDescriptionTwo.setText("setTex2DescPenDrive");
            textViewDescriptionThree.setText("setTex3DescPenDrive");
            textViewDescriptionFour.setText("setTex4DescPenDrive");
            textViewDescriptionFive.setText("setTex5DescPenDrive");

            spinnerDescriptionOne.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, PenDriveDescriptionFirst));
            spinnerDescriptionTwo.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, PenDriveDescriptionSecond));
            spinnerDescriptionThree.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, PenDriveDescriptionThird));
            spinnerDescriptionFour.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, PenDriveDescriptionFourth));
            spinnerDescriptionFive.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, PenDriveDescriptionFifth));

        }

        if (gettingValueTypeOfItem.equals("Pens")){

            textViewDescriptionOne.setText("setTex1DescPens");
            textViewDescriptionTwo.setText("setTex2DescPens");
            textViewDescriptionThree.setText("setTex3DescPens");
            textViewDescriptionFour.setText("setTex4DescPens");
            textViewDescriptionFive.setText("setTex5DescPens");

            spinnerDescriptionOne.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, PensDescriptionFirst));
            spinnerDescriptionTwo.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, PensDescriptionSecond));
            spinnerDescriptionThree.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, PensDescriptionThird));
            spinnerDescriptionFour.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, PensDescriptionFourth));
            spinnerDescriptionFive.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, PensDescriptionFifth));

        }

        if (gettingValueTypeOfItem.equals("Refrigerator")){

            textViewDescriptionOne.setText("setTex1DescRefrigerator");
            textViewDescriptionTwo.setText("setTex2DescRefrigerator");
            textViewDescriptionThree.setText("setTex3DescRefrigerator");
            textViewDescriptionFour.setText("setTex4DescRefrigerator");
            textViewDescriptionFive.setText("setTex5DescRefrigerator");

            spinnerDescriptionOne.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, RefrigeratorDescriptionFirst));
            spinnerDescriptionTwo.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, RefrigeratorDescriptionSecond));
            spinnerDescriptionThree.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, RefrigeratorDescriptionThird));
            spinnerDescriptionFour.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, RefrigeratorDescriptionFourth));
            spinnerDescriptionFive.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, RefrigeratorDescriptionFifth));

        }

        if (gettingValueTypeOfItem.equals("Smart Watches")){

            textViewDescriptionOne.setText("setTex1DescSmartWatches");
            textViewDescriptionTwo.setText("setTex1DescSmartWatches");
            textViewDescriptionThree.setText("setTex1DescSmartWatches");
            textViewDescriptionFour.setText("setTex1DescSmartWatches");
            textViewDescriptionFive.setText("setTex1DescSmartWatches");

            spinnerDescriptionOne.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, SmartWatchesDescriptionFirst));
            spinnerDescriptionTwo.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, SmartWatchesDescriptionSecond));
            spinnerDescriptionThree.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, SmartWatchesDescriptionThird));
            spinnerDescriptionFour.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, SmartWatchesDescriptionFourth));
            spinnerDescriptionFive.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, SmartWatchesDescriptionFifth));

        }

        if (gettingValueTypeOfItem.equals("Speaker")){

            textViewDescriptionOne.setText("setTex1DescSpeaker");
            textViewDescriptionTwo.setText("setTex2DescSpeaker");
            textViewDescriptionThree.setText("setTex3DescSpeaker");
            textViewDescriptionFour.setText("setTex4DescSpeaker");
            textViewDescriptionFive.setText("setTex5DescSpeaker");

            spinnerDescriptionOne.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, SpeakerDescriptionFirst));
            spinnerDescriptionTwo.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, SpeakerDescriptionSecond));
            spinnerDescriptionThree.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, SpeakerDescriptionThird));
            spinnerDescriptionFour.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, SpeakerDescriptionForth));
            spinnerDescriptionFive.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, SpeakerDescriptionFifth));

        }

        if (gettingValueTypeOfItem.equals("Sports Shoes")){

            textViewDescriptionOne.setText("setTex1DescSportsShoes");
            textViewDescriptionTwo.setText("setTex2DescSportsShoes");
            textViewDescriptionThree.setText("setTex3DescSportsShoes");
            textViewDescriptionFour.setText("setTex4DescSportsShoes");
            textViewDescriptionFive.setText("setTex5DescSportsShoes");

            spinnerDescriptionOne.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, SportsShoesDescriptionFirst));
            spinnerDescriptionTwo.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, SportsShoesDescriptionSecond));
            spinnerDescriptionThree.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, SportsShoesDescriptionThird));
            spinnerDescriptionFour.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, SportsShoesDescriptionFourth));
            spinnerDescriptionFive.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, SportsShoesDescriptionFifth));

        }

        if (gettingValueTypeOfItem.equals("Shoes")){

            textViewDescriptionOne.setText("setTex1DescShoes");
            textViewDescriptionTwo.setText("setTex2DescShoes");
            textViewDescriptionThree.setText("setTex3DescShoes");
            textViewDescriptionFour.setText("setTex4DescShoes");
            textViewDescriptionFive.setText("setTex5Desc");

            spinnerDescriptionOne.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, ShoesDescriptionFirst));
            spinnerDescriptionTwo.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, ShoesDescriptionSecond));
            spinnerDescriptionThree.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, ShoesDescriptionThird));
            spinnerDescriptionFour.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, ShoesDescriptionFourth));
            spinnerDescriptionFive.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, ShoesDescriptionFifth));

        }

        if (gettingValueTypeOfItem.equals("Sandal")){

            textViewDescriptionOne.setText("setTex1DescSandal");
            textViewDescriptionTwo.setText("setTex2DescSandal");
            textViewDescriptionThree.setText("setTex3DescSandal");
            textViewDescriptionFour.setText("setTex4DescSandal");
            textViewDescriptionFive.setText("setTex5DescSandal");

            spinnerDescriptionOne.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, SandalsDescriptionFirst));
            spinnerDescriptionTwo.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, SandalsDescriptionSecond));
            spinnerDescriptionThree.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, SandalsDescriptionThird));
            spinnerDescriptionFour.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, SandalsDescriptionFourth));
            spinnerDescriptionFive.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, SandalsDescriptionFifth));

        }

        if (gettingValueTypeOfItem.equals("Slippers")){

            textViewDescriptionOne.setText("setTex1DescSlippers");
            textViewDescriptionTwo.setText("setTex2DescSlippers");
            textViewDescriptionThree.setText("setTex3DescSlippers");
            textViewDescriptionFour.setText("setTex4DescSlippers");
            textViewDescriptionFive.setText("setTex5DescSlippers");

            spinnerDescriptionOne.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, SlippersDescriptionFirst));
            spinnerDescriptionTwo.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, SlippersDescriptionSecond));
            spinnerDescriptionThree.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, SlippersDescriptionThird));
            spinnerDescriptionFour.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, SlippersDescriptionFourth));
            spinnerDescriptionFive.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, SlippersDescriptionFifth));

        }

        if (gettingValueTypeOfItem.equals("School Bags")){

            textViewDescriptionOne.setText("setTex1DescSchoolBags");
            textViewDescriptionTwo.setText("setTex2DescSchoolBags");
            textViewDescriptionThree.setText("setTex3DescSchoolBags");
            textViewDescriptionFour.setText("setTex4DescSchoolBags");
            textViewDescriptionFive.setText("setTex5DescSchoolBags");

            spinnerDescriptionOne.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, SchoolDescriptionFirst));
            spinnerDescriptionTwo.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, SchoolDescriptionSecond));
            spinnerDescriptionThree.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, SchoolDescriptionThird));
            spinnerDescriptionFour.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, SchoolDescriptionFourth));
            spinnerDescriptionFive.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, SchoolDescriptionFifth));

        }

        if (gettingValueTypeOfItem.equals("Tiffin")){

            textViewDescriptionOne.setText("setTex1DescTiffin");
            textViewDescriptionTwo.setText("setTex2DescTiffin");
            textViewDescriptionThree.setText("setTex3DescTiffin");
            textViewDescriptionFour.setText("setTex4DescTiffin");
            textViewDescriptionFive.setText("setTex5DescTiffin");

            spinnerDescriptionOne.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, TiffinDescriptionFirst));
            spinnerDescriptionTwo.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, TiffinDescriptionSecond));
            spinnerDescriptionThree.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, TiffinDescriptionThird));
            spinnerDescriptionFour.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, TiffinDescriptionFourth));
            spinnerDescriptionFive.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, TiffinDescriptionFifth));

        }

        if (gettingValueTypeOfItem.equals("Text Books")){

            textViewDescriptionOne.setText("setTex1DescTextBooks");
            textViewDescriptionTwo.setText("setTex2DescTextBooks");
            textViewDescriptionThree.setText("setTex3DescTextBooks");
            textViewDescriptionFour.setText("setTex4DescTextBooks");
            textViewDescriptionFive.setText("setTex5DescTextBooks");

            spinnerDescriptionOne.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, TextBooksDescriptionFirst));
            spinnerDescriptionTwo.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, TextBooksDescriptionSecond));
            spinnerDescriptionThree.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, TextBooksDescriptionThird));
            spinnerDescriptionFour.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, TextBooksDescriptionFourth));
            spinnerDescriptionFive.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, TextBooksDescriptionFifth));

        }

        if (gettingValueTypeOfItem.equals("Tablets")){

            textViewDescriptionOne.setText("setTex1DescTablets");
            textViewDescriptionTwo.setText("setTex2DescTablets");
            textViewDescriptionThree.setText("setTex3DescTablets");
            textViewDescriptionFour.setText("setTex4DescTablets");
            textViewDescriptionFive.setText("setTex5DescTablets");

            spinnerDescriptionOne.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, TabletsDescriptionFirst));
            spinnerDescriptionTwo.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, TabletsDescriptionSecond));
            spinnerDescriptionThree.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, TabletsDescriptionThird));
            spinnerDescriptionFour.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, TabletsDescriptionFourth));
            spinnerDescriptionFive.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, TabletsDescriptionFifth));

        }

        if (gettingValueTypeOfItem.equals("Television")){

            textViewDescriptionOne.setText("setTex1DescTelevision");
            textViewDescriptionTwo.setText("setTex2DescTelevision");
            textViewDescriptionThree.setText("setTex3DescTelevision");
            textViewDescriptionFour.setText("setTex4DescTelevision");
            textViewDescriptionFive.setText("setTex5DescTelevision");

            spinnerDescriptionOne.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, TelevisionDescriptionFirst));
            spinnerDescriptionTwo.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, TelevisionDescriptionSecond));
            spinnerDescriptionThree.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, TelevisionDescriptionThird));
            spinnerDescriptionFour.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, TelevisionDescriptionFourth));
            spinnerDescriptionFive.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, TelevisionDescriptionFifth));

        }

        if (gettingValueTypeOfItem.equals("Teddy Bear")){

            textViewDescriptionOne.setText("setTex1DescTeddyBear");
            textViewDescriptionTwo.setText("setTex2DescTeddyBear");
            textViewDescriptionThree.setText("setTex3DescTeddyBear");
            textViewDescriptionFour.setText("setTex4DescTeddyBear");
            textViewDescriptionFive.setText("setTex5DescTeddyBear");

            spinnerDescriptionOne.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, TeddyBearDescriptionFirst));
            spinnerDescriptionTwo.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, TeddyBearDescriptionSecond));
            spinnerDescriptionThree.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, TeddyBearDescriptionThird));
            spinnerDescriptionFour.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, TeddyBearDescriptionFourth));
            spinnerDescriptionFive.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, TeddyBearDescriptionFifth));

        }

        if (gettingValueTypeOfItem.equals("Video Games")){

            textViewDescriptionOne.setText("setTex1DescVideoGames");
            textViewDescriptionTwo.setText("setTex2DescVideoGames");
            textViewDescriptionThree.setText("setTex3DescVideoGames");
            textViewDescriptionFour.setText("setTex4DescVideoGames");
            textViewDescriptionFive.setText("setTex5DescVideoGames");

            spinnerDescriptionOne.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, VideoGamesDescriptionFirst));
            spinnerDescriptionTwo.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, VideoGamesDescriptionSecond));
            spinnerDescriptionThree.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, VideoGamesDescriptionThird));
            spinnerDescriptionFour.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, VideoGamesDescriptionFourth));
            spinnerDescriptionFive.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, VideoGamesDescriptionFifth));

        }

        if (gettingValueTypeOfItem.equals("Webcam")){

            textViewDescriptionOne.setText("setTex1DescWebcam");
            textViewDescriptionTwo.setText("setTex2DescWebcam");
            textViewDescriptionThree.setText("setTex3DescWebcam");
            textViewDescriptionFour.setText("setTex4DescWebcam");
            textViewDescriptionFive.setText("setTex5DescWebcam");

            spinnerDescriptionOne.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, WebcamDescriptionFirst));
            spinnerDescriptionTwo.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, WebcamDescriptionSecond));
            spinnerDescriptionThree.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, WebcamDescriptionThird));
            spinnerDescriptionFour.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, WebcamDescriptionFourth));
            spinnerDescriptionFive.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, WebcamDescriptionFifth));

        }

        if (gettingValueTypeOfItem.equals("Water Bags")){

            textViewDescriptionOne.setText("setTex1DescWaterBags");
            textViewDescriptionTwo.setText("setTex2DescWaterBags");
            textViewDescriptionThree.setText("setTex3DescWaterBags");
            textViewDescriptionFour.setText("setTex4DescWaterBags");
            textViewDescriptionFive.setText("setTex5DescWaterBags");

            spinnerDescriptionOne.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, WaterBagsDescriptionFirst));
            spinnerDescriptionTwo.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, WaterBagsDescriptionSecond));
            spinnerDescriptionThree.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, WaterBagsDescriptionThird));
            spinnerDescriptionFour.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, WaterBagsDescriptionFourth));
            spinnerDescriptionFive.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, WaterBagsDescriptionFifth));

        }

        if (gettingValueTypeOfItem.equals("Women's Fashion")){

            textViewDescriptionOne.setText("setTex1DescWomensFashion");
            textViewDescriptionTwo.setText("setTex2DescWomensFashion");
            textViewDescriptionThree.setText("setTex3DescWomensFashion");
            textViewDescriptionFour.setText("setTex4DescWomensFashion");
            textViewDescriptionFive.setText("setTex5DescWomensFashion");

            spinnerDescriptionOne.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, WomensFashionDescriptionFirst));
            spinnerDescriptionTwo.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, WomensFashionDescriptionSecond));
            spinnerDescriptionThree.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, WomensFashionDescriptionThird));
            spinnerDescriptionFour.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, WomensFashionDescriptionFourth));
            spinnerDescriptionFive.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, WomensFashionDescriptionFifth));

        }

    }

}
