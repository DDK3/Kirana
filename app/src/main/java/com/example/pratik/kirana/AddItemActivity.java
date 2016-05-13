package com.example.pratik.kirana;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Base64;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class AddItemActivity extends AppCompatActivity {

    String valueFromSpinnerTypeOfItem = "Bluetooth";
    String valueFromSpinnerBrandOfItem = "BarbieA";
    String fullDescriptionOfItem = "";
    String defaultValueOfBrandOfItem[] = {"Select Brand Of Item"};
    String username;
    String type_of_item;
    String brand_of_item;
    String product_name;
    String mobileNo;
    String area;
    String price_of_item;
    String description_of_item;
    String UpdateIem = null;
    String descItemR = "Default", mobNoR = "", priceItemR = "", usernameRetailerR = "";
    String checkUpdateOrAdd;
    String urlDecided;

    int idR;

    private static int RESULT_LOAD_IMAGE = 1;

    Spinner spinnerTypeOfItem, spinnerBrandOfItem;
    EditText editTextUsernameInAddItem, editTextProductPrice, editTextDescriptionOfItem, editTextMobileNo, editTextNameOfItem, editTextAreaOfRetailer;
    ImageView imageViewInAddItemActivity;
    Button buttonAddItem, buttonUpdateItemInAddItemActivity;

    String Server_Address_To_Store_Item, Server_Address_To_Update_Item;

    String[] spinnerAreaOfRetailerArray = {"Select Area", "Jaipur", "Alibag", "Mahad"};

    //Array for Type of the item
    String[] typeOfItem = {"Select Type of Item", "Barbie", "Bluetooth", "Car Toys", "Charger", "Children's Books", "Computer",
            "Children's Fashion", "Earphone", "Fan", "Gents Watches", "Headsets", "Home Theater", "Hard Disks", "Keyboard",
            "Laptop", "Laptop Battery", "Light Bulbs", "Ladies Watches", "Magzines", "Mobiles", "Mobile Battery", "Men's Fashion", "Motherboard",
            "Mouse", "Movies CDs", "Music CDs", "Music DVDs", "Movies DVDs", "Note Books", "Other Books", "Oven", "Pen Drive", "Pens",
            "Refrigerator", "Smart Watches", "Speaker", "Sports Shoes", "Shoes", "Sandal", "Slippers", "School Bags", "Tiffin",
            "Text Books", "Tablets", "Television", "Teddy Bear", "Video Games", "Webcam", "Water Bags", "Women's Fashion"};

    //Array for the brand of the selected type of the item
    String[] BarbieBrands = {"Select Brand Of Item", "Mattle", "Barbie Kelly in India", "BarbieC", "BarbieD"};
    String[] BluetoothBrands = {"Select Brand Of Item", "BluetoothA", "BluetoothB", "BluetoothC", "BluetoothD"};
    String[] CarToysBrands = {"Select Brand Of Item", "CarToysA", "CarToysB", "CarToysC", "CarToysD"};
    String[] ChargerBrands = {"Select Brand Of Item", "ChargerA", "ChargerB", "ChargerC", "ChargerD"};
    String[] ChildrensBooksBrands = {"Select Brand Of Item", "Children's BooksA", "Children's BooksB", "Children's BooksC", "Children's BooksD"};
    String[] ChildrensFashionBrands = {"Select Brand Of Item", "Children's FashionA", "Children's FashionB", "Children's FashionC", "Children's FashionD"};
    String[] ComputerBrands = {"Select Brand Of Item", "ComputerA", "ComputerB", "ComputerC", "ComputerD"};
    String[] EarphoneBrands = {"Select Brand Of Item", "EarphoneA", "EarphoneB", "EarphoneC", "EarphoneD"};
    String[] FanBrands = {"Select Brand Of Item", "FanA", "FanB", "FanC", "FanD"};
    String[] GentsWatchesBrands = {"Select Brand Of Item", "Gents WatchesA", "Gents WatchesB", "Gents WatchesC", "Gents WatchesD"};
    String[] HeadsetsBrands = {"Select Brand Of Item", "HeadsetsA", "HeadsetsB", "HeadsetsC", "HeadsetsD"};
    String[] HomeTheaterBrands = {"Select Brand Of Item", "Home TheaterA", "Home TheaterB", "Home TheaterC", "Home TheaterD"};
    String[] HardDisksBrands = {"Select Brand Of Item", "Hard DisksA", "Hard DisksB", "Hard DisksC", "Hard DisksD"};
    String[] KeyboardBrands = {"Select Brand Of Item", "KeyboardA", "KeyboardB", "KeyboardC", "KeyboardD"};
    String[] LaptopBrands = {"Select Brand Of Item", "LaptopA", "LaptopB", "LaptopC", "LaptopD"};
    String[] LaptopBatteryBrands = {"Select Brand Of Item", "LaptopBatteryA", "LaptopBatteryB", "LaptopBatteryC", "LaptopBatteryD"};
    String[] LadiesWatchesBrands = {"Select Brand Of Item", "Ladies WatchesA", "Ladies WatchesB", "Ladies WatchesC", "Ladies WatchesD"};
    String[] LightBulbsBrands = {"Select Brand Of Item", "Light BulbsA", "Light BulbsB", "Light BulbsC", "Light BulbsD"};
    String[] MagzinesBrands = {"Select Brand Of Item", "MagzinesA", "MagzinesB", "MagzinesC", "MagzinesD"};
    String[] MobileBrands = {"Select Brand Of Item", "Nokia", "iPhone", "Samsung", "Lenovo","Micromax"};
    String[] MobileBatteryBrands = {"Select Brand Of Item", "Mobile BatteryA", "Mobile BatteryB", "Mobile BatteryC", "Mobile BatteryD"};
    String[] MensFashionBrands = {"Select Brand Of Item", "Men's FashionA", "Men's FashionB", "Men's FashionC", "Men's FashionD"};
    String[] MotherboardBrands = {"Select Brand Of Item", "MotherboardA", "MotherboardB", "MotherboardC", "MotherboardD"};
    String[] MouseBrands = {"Select Brand Of Item", "MouseA", "MouseB", "MouseC", "MouseD"};
    String[] MoviesCDsBrands = {"Select Brand Of Item", "Movies CDsA", "Movies CDsB", "Movies CDsC", "Movies CDsD"};
    String[] MusicCDsBrands = {"Select Brand Of Item", "Music CDsA", "Music CDsB", "Music CDsC", "Music CDsD"};
    String[] MoviesDVDsBrands = {"Select Brand Of Item", "MoviesDVDsA", "MoviesDVDsB", "MoviesDVDsC", "MoviesDVDsD"};
    String[] NoteBooksBrands = {"Select Brand Of Item", "Note BooksA", "Note BooksB", "Note BooksC", "Note BooksD"};
    String[] OtherBooksBrands = {"Select Brand Of Item", "Other BooksA", "Other BooksB", "Other BooksC", "Other BooksD"};
    String[] OvenBrands = {"Select Brand Of Item", "OvenA", "OvenB", "OvenC", "OvenD"};
    String[] PenDriveBrands = {"Select Brand Of Item", "Pen DriveA", "Pen DriveB", "Pen DriveC", "Pen DriveD"};
    String[] PensBrands = {"Select Brand Of Item", "PensA", "PensB", "PensC", "PensD"};
    String[] RefrigeratorBrands = {"Select Brand Of Item", "RefrigeratorA", "RefrigeratorB", "RefrigeratorC", "RefrigeratorD"};
    String[] SmartWatchesBrands = {"Select Brand Of Item", "Smart WatchesA", "Smart WatchesB", "Smart WatchesC", "Smart WatchesD"};
    String[] SpeakerBrands = {"Select Brand Of Item", "SpeakerA", "SpeakerB", "SpeakerC", "SpeakerD"};
    String[] SportsShoesBrands = {"Select Brand Of Item", "Sports ShoesA", "Sports ShoesB", "Sports ShoesC", "Sports ShoesD"};
    String[] ShoesBrands = {"Select Brand Of Item", "ShoesA", "ShoesB", "ShoesC", "ShoesD"};
    String[] SandalBrands = {"Select Brand Of Item", "SandalA","SandalB","SandalC","SandalD"};
    String[] SlippersBrands = {"Select Brand Of Item", "SlippersA", "SlippersB", "SlippersC", "SlippersD"};
    String[] SchoolBagsBrands = {"Select Brand Of Item", "School BagsA", "School BagsB", "School BagsC", "School BagsD"};
    String[] TabletsBrands = {"Select Brand Of Item", "TabletsA", "TabletsB", "TabletsC", "TabletsD"};
    String[] TiffinBrands = {"Select Brand Of Item", "TiffinA", "TiffinB", "TiffinC", "TiffinD"};
    String[] TextBooksBrands = {"Select Brand Of Item", "Text BooksA", "Text BooksB", "Text BooksC", "Text BooksD"};
    String[] TelevisionBrands = {"Select Brand Of Item", "TelevisionA", "TelevisionB", "TelevisionC", "TelevisionD"};
    String[] TeddyBearBrands = {"Select Brand Of Item", "Teddy BearA", "Teddy BearB", "Teddy BearC", "Teddy BearD"};
    String[] VideoGamesBrands = {"Select Brand Of Item", "Video GamesA", "Video GamesB", "Video GamesC", "Video GamesD"};
    String[] WaterBagsBrands = {"Select Brand Of Item", "Water BagsA", "Water BagsB", "Water BagsC", "Water BagsD"};
    String[] WebcamBrands = {"Select Brand Of Item", "WebcamA", "WebcamB", "WebcamC", "WebcamD"};


/*
    //Array for the Name Of the Items By Brands
    //Array for Barbie Names
    String[] NameOfTheBarbieABrands = {"Select Name Of Item", "1BarbieA", "2BarbieA", "3BarbieA", "4BarbieA"};
    String[] NameOfTheBarbieBBrands = {"Select Name Of Item", "1BarbieB", "1BarbieB", "1BarbieB", "1BarbieB"};
    String[] NameOfTheBarbieCBrands = {"Select Name Of Item", "1BarbieC", "2BarbieC", "3BarbieC", "4BarbieC"};
    String[] NameOfTheBarbieDBrands = {"Select Name Of Item", "1BarbieD", "2BarbieD", "3BarbieD", "4BarbieD"};

    //Array for Bluetooth Names
    String[] NameOfTheBleutoothABrands = {"Select Name Of Item", "1BluetoothA", "2BluetoothA", "3BluetoothA", "4BluetoothA"};
    String[] NameOfTheBleutoothBBrands = {"Select Name Of Item", "1BluetoothA", "2BluetoothB", "3BluetoothB", "4BluetoothB"};
    String[] NameOfTheBleutoothCBrands = {"Select Name Of Item", "1BluetoothC", "2BluetoothC", "3BluetoothC", "4BluetoothC"};
    String[] NameOfTheBleutoothDBrands = {"Select Name Of Item", "1BluetoothD", "2BluetoothD", "3BluetoothD", "4BluetoothD"};

    //Array for Car Toys Names
    String[] NameOfTheCarToysABrands = {"Select Name Of Item", "1Car ToysA", "2Car ToysA", "3Car ToysA", "4Car ToysA"};
    String[] NameOfTheCarToysBBrands = {"Select Name Of Item", "1Car ToysB", "2Car ToysB", "3Car ToysB", "4Car ToysB"};
    String[] NameOfTheCarToysCBrands = {"Select Name Of Item", "1Car ToysC", "2Car ToysC", "3Car ToysC", "4Car ToysC"};
    String[] NameOfTheCarToysDBrands = {"Select Name Of Item", "1Car ToysD", "2Car ToysD", "3Car ToysD", "4Car ToysD"};

    //Array for Charger Names
    String[] NameOfTheChargerABrands = {"Select Name Of Item", "1ChargerA", "2BluetoothA", "3BluetoothA", "4BluetoothA"};
    String[] NameOfTheChargerBBrands = {"Select Name Of Item", "1ChargerB", "2BluetoothB", "3BluetoothB", "4BluetoothB"};
    String[] NameOfTheChargerCBrands = {"Select Name Of Item", "1ChargerC", "2BluetoothC", "3BluetoothC", "4BluetoothC"};
    String[] NameOfTheChargerDBrands = {"Select Name Of Item", "1ChargerD", "2BluetoothD", "3BluetoothD", "4BluetoothD"};

    //Array for Children's Books Names
    String[] NameOfTheChildrensBooksABrands = {"Select Name Of Item", "1Children's BooksA", "2Children's BooksA", "3Children's BooksA", "4Children's BooksA"};
    String[] NameOfTheChildrensBooksBBrands = {"Select Name Of Item", "1Childre's BooksB", "2Childre's BooksB", "3Childre's BooksB", "4Childre's BooksB"};
    String[] NameOfTheChildrensBooksCBrands = {"Select Name Of Item", "1Childre's BooksC", "2Childre's BooksC", "3Childre's BooksC", "4Childre's BooksC"};
    String[] NameOfTheChildrensBooksDBrands = {"Select Name Of Item", "1Childre's BooksD", "2Childre's BooksD", "3Childre's BooksD", "4Childre's BooksD"};

    //Array for Children's Fashion Names
    String[] NameOfTheChildrensFashionABrands = {"Select Name Of Item", "1Children's FashionA", "2Children's FashionA", "3Children's FashionA", "4Children's FashionA"};
    String[] NameOfTheChildrensFashionBBrands = {"Select Name Of Item", "1Children's FashionB", "2Children's FashionB", "3Children's FashionB", "4Children's FashionB"};
    String[] NameOfTheChildrensFashionCBrands = {"Select Name Of Item", "1Children's FashionC", "2Children's FashionC", "3Children's FashionC", "4Children's FashionC"};
    String[] NameOfTheChildrensFashionDBrands = {"Select Name Of Item", "1Children's FashionD", "2Children's FashionD", "3Children's FashionD", "4Children's FashionD"};

    //Array for Computer Names
    String[] NameOfTheComputerABrands = {"Select Name Of Item" ,"1ComputerA", "2ComputerA", "3ComputerA", "4ComputerA"};
    String[] NameOfTheComputerBBrands = {"Select Name Of Item", "1ComputerB", "2ComputerB", "3ComputerB", "4ComputerB"};
    String[] NameOfTheComputerCBrands = {"Select Name Of Item", "1ComputerC", "2ComputerC", "3ComputerC", "4ComputerC"};
    String[] NameOfTheComputerDBrands = {"Select Name Of Item", "1ComputerD", "2ComputerD", "3ComputerD", "4ComputerD"};

    //Array for the Webcam Names
    String[] NameOfTheEarphoneABrands = {"Select Name Of Item", "1EarphoneA", "2EarphoneA", "3EarphoneA", "4EarphoneA"};
    String[] NameOfTheEarphoneBBrands = {"Select Name Of Item", "1WebcamB", "2WebcamB", "3EarphoneB", "4EarphoneB"};
    String[] NameOfTheEarphoneCBrands = {"Select Name Of Item", "1WebcamC", "2WebcamC", "3EarphoneC", "4EarphoneC"};
    String[] NameOfTheEarphoneDBrands = {"Select Name Of Item", "1WebcamD", "2WebcamD", "3WebcamD", "4WebcamD"};

    //Array for Fan Names
    String[] NameOfTheFanABrands = {"Select Name Of Item", "1FanA", "2FanA", "3FanA", "4FanA"};
    String[] NameOfTheFanBBrands = {"Select Name Of Item", "1FanB", "2FanB", "3FanB", "4FanB"};
    String[] NameOfTheFanCBrands = {"Select Name Of Item", "1FanC", "2FanC", "3FanC", "4FanC"};
    String[] NameOfTheFanDBrands = {"Select Name Of Item", "1FanD", "2FanD", "3FanD", "4FanD"};

    //Array for the Gent's Watches Names
    String[] NameOfTheGentsWatchABrands = {"Select Name Of Item", "1GentsWatchA", "2GentsWatchA", "3GentsWatchA", "4GentsWatchA"};
    String[] NameOfTheGentsWatchBBrands = {"Select Name Of Item", "1GentsWatchB", "2GentsWatchB", "3GentsWatchB", "4GentsWatchB"};
    String[] NameOfTheGentsWatchCBrands = {"Select Name Of Item", "1GentsWatchC", "2GentsWatchC", "3GentsWatchC", "4GentsWatchC"};
    String[] NameOfTheGentsWatchDBrands = {"Select Name Of Item", "1GentsWatchD", "2GentsWatchD", "3GentsWatchD", "4GentsWatchD"};

    //Array for the Headsets Names
    String[] NameOfTheHeadsetsABrands = {"Select Name Of Item", "1HeadsetsA", "2HeadsetsA", "3HeadsetsA", "4HeadsetsA"};
    String[] NameOfTheHeadsetsBBrands = {"Select Name Of Item", "1HeadsetsB", "2HeadsetsB", "3HeadsetsB", "4HeadsetsB"};
    String[] NameOfTheHeadsetsCBrands = {"Select Name Of Item", "1HeadsetsC", "2HeadsetsC", "3HeadsetsC", "4HeadsetsC"};
    String[] NameOfTheHeadsetsDBrands = {"Select Name Of Item", "1HeadsetsD", "2HeadsetsD", "3HeadsetsD", "4HeadsetsD"};

    //Array for the HomeTheater Names
    String[] NameOfTheHomeTheaterABrands = {"Select Name Of Item", "1HomeTheaterA", "2HomeTheaterA", "3HomeTheaterA", "4HomeTheaterA"};
    String[] NameOfTheHomeTheaterBBrands = {"Select Name Of Item", "1HomeTheaterB", "2HomeTheaterB", "3HomeTheaterB", "4HomeTheaterB"};
    String[] NameOfTheHomeTheaterCBrands = {"Select Name Of Item", "1HomeTheaterC", "2HomeTheaterC", "3HomeTheaterC", "4HomeTheaterC"};
    String[] NameOfTheHomeTheaterDBrands = {"Select Name Of Item", "1HomeTheaterD", "2HomeTheaterD", "3HomeTheaterD", "4HomeTheaterD"};

    //Array for the Hard Disks Names
    String[] NameOfTheHardDisksABrands = {"Select Name Of Item", "1HardDisksA", "2HardDisksA", "3HardDisksA", "4HardDisksA"};
    String[] NameOfTheHardDisksBBrands = {"Select Name Of Item", "1HardDisksB", "2HardDisksB", "3HardDisksB", "4HardDisksB"};
    String[] NameOfTheHardDisksCBrands = {"Select Name Of Item", "1HardDisksC", "2HardDisksC", "3HardDisksC", "4HardDisksC"};
    String[] NameOfTheHardDisksDBrands = {"Select Name Of Item", "1HardDisksD", "2HardDisksD", "3HardDisksD", "4HardDisksD"};

    //Array for the Keyboard Names
    String[] NameOfTheKeyboardABrands = {"Select Name Of Item", "1KeyboardA", "2KeyboardA", "3KeyboardA", "4KeyboardA"};
    String[] NameOfTheKeyboardBBrands = {"Select Name Of Item", "1KeyboardB", "2KeyboardB", "3KeyboardB", "4KeyboardB"};
    String[] NameOfTheKeyboardCBrands = {"Select Name Of Item", "1KeyboardC", "2KeyboardC", "3KeyboardC", "4KeyboardC"};
    String[] NameOfTheKeyboardDBrands = {"Select Name Of Item", "1KeyboardD", "2KeyboardD", "3KeyboardD", "4KeyboardD"};

    //Array for the Laptop Names
    String[] NameOfTheLaptopABrands = {"Select Name Of Item", "1LaptopA", "2LaptopA", "3LaptopA", "4LaptopA"};
    String[] NameOfTheLaptopBBrands = {"Select Name Of Item", "1LaptopB", "2LaptopB", "3LaptopB", "4LaptopB"};
    String[] NameOfTheLaptopCBrands = {"Select Name Of Item", "1LaptopC", "2LaptopC", "3LaptopC", "4LaptopC"};
    String[] NameOfTheLaptopDBrands = {"Select Name Of Item", "1LaptopD", "2LaptopD", "3LaptopD", "4LaptopD"};

    //Array for the Laptop Battery Names
    String[] NameOfTheLaptopBatteryABrands = {"Select Name Of Item", "1LaptopA", "2LaptopA", "3LaptopA", "4LaptopA"};
    String[] NameOfTheLaptopBatteryBBrands = {"Select Name Of Item", "1LaptopB", "2LaptopB", "3LaptopB", "4LaptopB"};
    String[] NameOfTheLaptopBatteryCBrands = {"Select Name Of Item", "1LaptopC", "2LaptopC", "3LaptopC", "4LaptopC"};
    String[] NameOfTheLaptopBatteryDBrands = {"Select Name Of Item", "1LaptopD", "2LaptopD", "3LaptopD", "4LaptopD"};


    //Array for the Ladies Watches Names
    String[] NameOfTheLadiesWatchesABrands = {"Select Name Of Item", "1Ladies WatchesA", "2Ladies WatchesA", "3Ladies WatchesA", "4Ladies WatchesA"};
    String[] NameOfTheLadiesWatchesBBrands = {"Select Name Of Item", "1Ladies WatchesB", "2Ladies WatchesB", "3Ladies WatchesB", "4Ladies WatchesB"};
    String[] NameOfTheLadiesWatchesCBrands = {"Select Name Of Item", "1Ladies WatchesC", "2Ladies WatchesC", "3Ladies WatchesC", "4Ladies WatchesC"};
    String[] NameOfTheLadiesWatchesDBrands = {"Select Name Of Item", "1Ladies WatchesD", "2Ladies WatchesD", "3Ladies WatchesD", "4Ladies WatchesD"};

    //Array for the Light Bulbs Names
    String[] NameOfTheLightBulbsABrands = {"Select Name Of Item", "1Light BulbsA", "2Light BulbsA", "3Light BulbsA", "4Light BulbsA"};
    String[] NameOfTheLightBulbsBBrands = {"Select Name Of Item", "1Light BulbsB", "2Light BulbsB", "3Light BulbsB", "4Light BulbsB"};
    String[] NameOfTheLightBulbsCBrands = {"Select Name Of Item", "1Light BulbsC", "2Light BulbsC", "3Light BulbsC", "4Light BulbsC"};
    String[] NameOfTheLightBulbsDBrands = {"Select Name Of Item", "1Light BulbsD", "2Light BulbsD", "3Light BulbsD", "4Light BulbsD"};

    //Array for the Magzines Names
    String[] NameOfTheMagzinesABrands = {"Select Name Of Item", "1MagzinesA", "2MagzinesA", "3MagzinesA", "4MagzinesA"};
    String[] NameOfTheMagzinesBBrands = {"Select Name Of Item", "1MagzinesB", "2MagzinesB", "3MagzinesB", "4MagzinesB"};
    String[] NameOfTheMagzinesCBrands = {"Select Name Of Item", "1MagzinesC", "2MagzinesC", "3MagzinesC", "4MagzinesC"};
    String[] NameOfTheMagzinesDBrands = {"Select Name Of Item", "1MagzinesD", "2MagzinesD", "3MagzinesD", "4MagzinesD"};

    //Array for the Mobile Names
    String[] NameOfTheMobileABrands = {"Select Name Of Item", "1MobileA", "2MobileA", "3MobileA", "4MobileA"};
    String[] NameOfTheMobileBBrands = {"Select Name Of Item", "1MobileB", "2MobileB", "3MobileB", "4MobileB"};
    String[] NameOfTheMobileCBrands = {"Select Name Of Item", "1MobileC", "2MobileC", "3MobileC", "4MobileC"};
    String[] NameOfTheMobileDBrands = {"Select Name Of Item", "1MobileD", "2MobileD", "3MobileD", "4MobileD"};

    //Array for the Mobile Battery Names
    String[] NameOfTheMobileBatteryABrands = {"Select Name Of Item", "1MobileBatteryA", "2MobileBatteryA", "3MobileBatteryA", "4MobileBatteryA"};
    String[] NameOfTheMobileBatteryBBrands = {"Select Name Of Item", "1MobileBatteryB", "2MobileBatteryB", "3MobileBatteryB", "4MobileBatteryB"};
    String[] NameOfTheMobileBatteryCBrands = {"Select Name Of Item", "1MobileBatteryC", "2MobileBatteryC", "3MobileBatteryC", "4MobileBatteryC"};
    String[] NameOfTheMobileBatteryDBrands = {"Select Name Of Item", "1MobileBatteryD", "2MobileBatteryD", "3MobileBatteryD", "4MobileBatteryD"};

    //Array for the Men's Fashion Names
    String[] NameOfTheMensFashionABrands = {"Select Name Of Item", "1MensFashionA", "2MensFashionA", "3MensFashionA", "4MensFashionA"};
    String[] NameOfTheMensFashionBBrands = {"Select Name Of Item", "1MensFashionB", "2MensFashionB", "3MensFashionB", "4MensFashionB"};
    String[] NameOfTheMensFashionCBrands = {"Select Name Of Item", "1MensFashionC", "2MensFashionC", "3MensFashionC", "4MensFashionC"};
    String[] NameOfTheMensFashionDBrands = {"Select Name Of Item", "1MensFashionD", "2MensFashionD", "3MensFashionD", "4MensFashionD"};

    //Array for the Motherboard Names
    String[] NameOfTheMotherboardABrands = {"Select Name Of Item", "1MotherboardA", "2MotherboardA", "3MotherboardA", "4MotherboardA"};
    String[] NameOfTheMotherboardBBrands = {"Select Name Of Item", "1MotherboardB", "2MotherboardB", "3MotherboardB", "4MotherboardB"};
    String[] NameOfTheMotherboardCBrands = {"Select Name Of Item", "1MotherboardC", "2MotherboardC", "3MotherboardC", "4MotherboardC"};
    String[] NameOfTheMotherboardDBrands = {"Select Name Of Item", "1MotherboardD", "2MotherboardD", "3MotherboardD", "4MotherboardD"};

    //Array for the Mouse Names
    String[] NameOfTheMouseABrands = {"Select Name Of Item", "1MouseA", "2MouseA", "3MouseA", "4MouseA"};
    String[] NameOfTheMouseBBrands = {"Select Name Of Item", "1MouseB", "2MouseB", "3MouseB", "4MouseB"};
    String[] NameOfTheMouseCBrands = {"Select Name Of Item", "1MouseC", "2MouseC", "3MouseC", "4MouseC"};
    String[] NameOfTheMouseDBrands = {"Select Name Of Item", "1MouseD", "2MouseD", "3MouseD", "4MouseD"};

    //Array for the Movies CDs Names
    String[] NameOfTheMoviesCDsABrands = {"Select Name Of Item", "1MoviesCDsA", "2MoviesCDsA", "3MoviesCDsA", "4MoviesCDsA"};
    String[] NameOfTheMoviesCDsBBrands = {"Select Name Of Item", "1MoviesCDsB", "2MoviesCDsB", "3MoviesCDsB", "4MoviesCDsB"};
    String[] NameOfTheMoviesCDsCBrands = {"Select Name Of Item", "1MoviesCDsC", "2MoviesCDsC", "3MoviesCDsC", "4MoviesCDsC"};
    String[] NameOfTheMoviesCDsDBrands = {"Select Name Of Item", "1MoviesCDsD", "2MoviesCDsD", "3MoviesCDsD", "4MoviesCDsD"};

    //Array for the Music CDs Names
    String[] NameOfTheMusicCDsABrands = {"Select Name Of Item", "1MusicCDsA", "2MusicCDsA", "3MusicCDsA", "4MusicCDsA"};
    String[] NameOfTheMusicCDsBBrands = {"Select Name Of Item", "1MusicCDsB", "2MusicCDsB", "3MusicCDsB", "4MusicCDsB"};
    String[] NameOfTheMusicCDsCBrands = {"Select Name Of Item", "1MusicCDsC", "2MusicCDsC", "3MusicCDsC", "4MusicCDsC"};
    String[] NameOfTheMusicCDsDBrands = {"Select Name Of Item", "1MusicCDsD", "2MusicCDsD", "3MusicCDsD", "4MusicCDsD"};

    //Array for the Movies DVDs Names
    String[] NameOfTheMoviesDVDsABrands = {"Select Name Of Item", "1MoviesDVDsA", "2MoviesDVDsA", "3MoviesDVDsA", "4MoviesDVDsA"};
    String[] NameOfTheMoviesDVDsBBrands = {"Select Name Of Item", "1MoviesDVDsB", "2MoviesDVDsB", "3MoviesDVDsB", "4MoviesDVDsB"};
    String[] NameOfTheMoviesDVDsCBrands = {"Select Name Of Item", "1MoviesDVDsC", "2MoviesDVDsC", "3MoviesDVDsC", "4MoviesDVDsC"};
    String[] NameOfTheMoviesDVDsDBrands = {"Select Name Of Item", "1MoviesDVDsD", "2MoviesDVDsD", "3MoviesDVDsD", "4MoviesDVDsD"};

    //Array for the Music DVDs Names
    String[] NameOfTheMusicDVDsABrands = {"Select Name Of Item", "1MusicDVDsA", "3MusicDVDsA", "3MusicDVDsA", "4MusicDVDsA"};
    String[] NameOfTheMusicDVDsBBrands = {"Select Name Of Item", "1MusicDVDsB", "3MusicDVDsB", "3MusicDVDsB", "4MusicDVDsB"};
    String[] NameOfTheMusicDVDsCBrands = {"Select Name Of Item", "1MusicDVDsC", "3MusicDVDsC", "3MusicDVDsC", "4MusicDVDsC"};
    String[] NameOfTheMusicDVDsDBrands = {"Select Name Of Item", "1MusicDVDsD", "3MusicDVDsD", "3MusicDVDsD", "4MusicDVDsD"};

    //Array for the Note Books Names
    String[] NameOfTheNoteBooksABrands = {"Select Name Of Item", "1Note BooksA", "2Note BooksA", "3Note BooksA", "4Note BooksA"};
    String[] NameOfTheNoteBooksBBrands = {"Select Name Of Item", "1Note BooksB", "2Note BooksB", "3Note BooksB", "4Note BooksB"};
    String[] NameOfTheNoteBooksCBrands = {"Select Name Of Item", "1Note BooksC", "2Note BooksC", "3Note BooksC", "4Note BooksC"};
    String[] NameOfTheNoteBooksDBrands = {"Select Name Of Item", "1Note BooksD", "2Note BooksD", "3Note BooksD", "4Note BooksD"};

    //Array for the Other Books Names
    String[] NameOfTheOtherBooksABrands = {"Select Name Of Item", "1Other BooksA", "2Other BooksA", "3Other BooksA", "4Other BooksA"};
    String[] NameOfTheOtherBooksBBrands = {"Select Name Of Item", "1Other BooksB", "2Other BooksB", "3Other BooksB", "4Other BooksB"};
    String[] NameOfTheOtherBooksCBrands = {"Select Name Of Item", "1Other BooksC", "2Other BooksC", "3Other BooksC", "4Other BooksC"};
    String[] NameOfTheOtherBooksDBrands = {"Select Name Of Item", "1Other BooksD", "2Other BooksD", "3Other BooksD", "4Other BooksD"};

    //Array for the Oven Names
    String[] NameOfTheOvenABrands = {"Select Name Of Item", "1OvenA", "2OvenA", "3OvenA", "4OvenA", };
    String[] NameOfTheOvenBBrands = {"Select Name Of Item", "1OvenB", "2OvenB", "3OvenB", "4OvenB", };
    String[] NameOfTheOvenCBrands = {"Select Name Of Item", "1OvenC", "2OvenC", "3OvenC", "4OvenC", };
    String[] NameOfTheOvenDBrands = {"Select Name Of Item", "1OvenD", "2OvenD", "3OvenD", "4OvenD", };

    //Array for the Pen Drive Names
    String[] NameOfThePenDriveABrands = {"Select Name Of Item", "1Pen DriveA", "2Pen DriveA", "3Pen DriveA", "4Pen DriveA"};
    String[] NameOfThePenDriveBBrands = {"Select Name Of Item", "1Pen DriveB", "2Pen DriveB", "3Pen DriveB", "4Pen DriveB"};
    String[] NameOfThePenDriveCBrands = {"Select Name Of Item", "1Pen DriveC", "2Pen DriveC", "3Pen DriveC", "4Pen DriveC"};
    String[] NameOfThePenDriveDBrands = {"Select Name Of Item", "1Pen DriveD", "2Pen DriveD", "3Pen DriveD", "4Pen DriveD"};

    //Array for the Pens Names
    String[] NameOfThePenABrands = {"Select Name Of Item", "1PensA", "2PensA", "3PensA", "4PensA"};
    String[] NameOfThePenBBrands = {"Select Name Of Item", "1PensB", "2PensB", "3PensB", "4PensB"};
    String[] NameOfThePenCBrands = {"Select Name Of Item", "1PensC", "2PensC", "3PensC", "4PensC"};
    String[] NameOfThePenDBrands = {"Select Name Of Item", "1PensD", "2PensD", "3PensD", "4PensD"};

    //Array for the Refrigerator Names
    String[] NameOfTheRefrigeratorABrands = {"Select Name Of Item", "1RefrigeratorA", "2RefrigeratorA", "3RefrigeratorA", "4RefrigeratorA"};
    String[] NameOfTheRefrigeratorBBrands = {"Select Name Of Item", "1RefrigeratorB", "2RefrigeratorB", "3RefrigeratorB", "4RefrigeratorB"};
    String[] NameOfTheRefrigeratorCBrands = {"Select Name Of Item", "1RefrigeratorC", "2RefrigeratorC", "3RefrigeratorC", "4RefrigeratorC"};
    String[] NameOfTheRefrigeratorDBrands = {"Select Name Of Item", "1RefrigeratorD", "2RefrigeratorD", "3RefrigeratorD", "4RefrigeratorD"};

    //Array for the Smart Watches Names
    String[] NameOfTheSmartWatchesABrands = {"Select Name Of Item", "1Smart WatchesA", "2Smart WatchesA", "3Smart WatchesA", "4Smart WatchesA"};
    String[] NameOfTheSmartWatchesBBrands = {"Select Name Of Item", "1Smart WatchesB", "2Smart WatchesB", "3Smart WatchesB", "4Smart WatchesB"};
    String[] NameOfTheSmartWatchesCBrands = {"Select Name Of Item", "1Smart WatchesC", "2Smart WatchesC", "3Smart WatchesC", "4Smart WatchesC"};
    String[] NameOfTheSmartWatchesDBrands = {"Select Name Of Item", "1Smart WatchesD", "2Smart WatchesD", "3Smart WatchesD", "4Smart WatchesD"};

    //Array for the Speaker Names
    String[] NameOfTheSpeakerABrands = {"Select Name Of Item", "1SpeakerA", "1SpeakerA", "3SpeakerA", "4SpeakerA"};
    String[] NameOfTheSpeakerBBrands = {"Select Name Of Item", "1SpeakerB", "1SpeakerB", "3SpeakerB", "4SpeakerB"};
    String[] NameOfTheSpeakerCBrands = {"Select Name Of Item", "1SpeakerC", "1SpeakerC", "3SpeakerC", "4SpeakerC"};
    String[] NameOfTheSpeakerDBrands = {"Select Name Of Item", "1SpeakerD", "1SpeakerD", "3SpeakerD", "4SpeakerD"};

    //Array for the Sports Shoes Names
    String[] NameOfTheSportsShoesABrands = {"Select Name Of Item", "1SportsShoesA", "2SportsShoesA", "3SportsShoesA", "4SportsShoesA"};
    String[] NameOfTheSportsShoesBBrands = {"Select Name Of Item", "1SportsShoesB", "2SportsShoesB", "3SportsShoesB", "4SportsShoesB"};
    String[] NameOfTheSportsShoesCBrands = {"Select Name Of Item", "1SportsShoesC", "2SportsShoesC", "3SportsShoesC", "4SportsShoesC"};
    String[] NameOfTheSportsShoesDBrands = {"Select Name Of Item", "1SportsShoesD", "2SportsShoesD", "3SportsShoesD", "4SportsShoesD"};

    //Array for the Shoes Names
    String[] NameOfTheShoesABrands = {"Select Name Of Item", "1ShoesA", "2ShoesA", "3ShoesA", "4ShoesA"};
    String[] NameOfTheShoesBBrands = {"Select Name Of Item", "1ShoesB", "2ShoesB", "3ShoesB", "4ShoesB"};
    String[] NameOfTheShoesCBrands = {"Select Name Of Item", "1ShoesC", "2ShoesC", "3ShoesC", "4ShoesC"};
    String[] NameOfTheShoesDBrands = {"Select Name Of Item", "1ShoesD", "2ShoesD", "3ShoesD", "4ShoesD"};

    //Array for the Sandal Names
    String[] NameOfTheSandalABrands = {"Select Name Of Item", "1SandalA", "2SandalA", "3SandalA", "4SandalA"};
    String[] NameOfTheSandalBBrands = {"Select Name Of Item", "1SandalB", "2SandalB", "3SandalB", "4SandalB"};
    String[] NameOfTheSandalCBrands = {"Select Name Of Item", "1SandalC", "2SandalC", "3SandalC", "4SandalC"};
    String[] NameOfTheSandalDBrands = {"Select Name Of Item", "1SandalD", "2SandalD", "3SandalD", "4SandalD"};

    //Array for the Slippers Names
    String[] NameOfTheSlippersABrands = {"Select Name Of Item", "1SlippersA", "2SlippersA", "3SlippersA", "4SlippersA"};
    String[] NameOfTheSlippersBBrands = {"Select Name Of Item", "1SlippersB", "2SlippersB", "3SlippersB", "4SlippersB"};
    String[] NameOfTheSlippersCBrands = {"Select Name Of Item", "1SlippersC", "2SlippersC", "3SlippersC", "4SlippersC"};
    String[] NameOfTheSlippersDBrands = {"Select Name Of Item", "1SlippersD", "2SlippersD", "3SlippersD", "4SlippersD"};

    //Array for the School Bags Names
    String[] NameOfTheSchoolBagsABrands = {"Select Name Of Item", "1School BagsA", "2School BagsA", "3School BagsA", "4School BagsA"};
    String[] NameOfTheSchoolBagsBBrands = {"Select Name Of Item", "1School BagsB", "2School BagsB", "3School BagsB", "4School BagsB"};
    String[] NameOfTheSchoolBagsCBrands = {"Select Name Of Item", "1School BagsC", "2School BagsC", "3School BagsC", "4School BagsC"};
    String[] NameOfTheSchoolBagsDBrands = {"Select Name Of Item", "1School BagsD", "2School BagsD", "3School BagsD", "4School BagsD"};

    //Array for the Tablets Names
    String[] NameOfTheTabletsABrands = {"Select Name Of Item", "1TabletsA", "2TabletsA", "3TabletsA", "4TabletsA"};
    String[] NameOfTheTabletsBBrands = {"Select Name Of Item", "1TabletsB", "2TabletsB", "3TabletsB", "4TabletsB"};
    String[] NameOfTheTabletsCBrands = {"Select Name Of Item", "1TabletsC", "2TabletsC", "3TabletsC", "4TabletsC"};
    String[] NameOfTheTabletsDBrands = {"Select Name Of Item", "1TabletsD", "2TabletsD", "3TabletsD", "4TabletsD"};

    //Array for the Tiffin Names
    String[] NameOfTheTiffinABrands = {"Select Name Of Item", "1TiffinA", "2TiffinA", "3TiffinA", "4TiffinA"};
    String[] NameOfTheTiffinBBrands = {"Select Name Of Item", "1TiffinB", "2TiffinB", "3TiffinB", "4TiffinB"};
    String[] NameOfTheTiffinCBrands = {"Select Name Of Item", "1TiffinC", "2TiffinC", "3TiffinC", "4TiffinC"};
    String[] NameOfTheTiffinDBrands = {"Select Name Of Item", "1TiffinD", "2TiffinD", "3TiffinD", "4TiffinD"};

    //Array for the Text Books Names
    String[] NameOfTheTextBooksABrands = {"Select Name Of Item", "1Text BooksA", "2Text BooksA", "3Text BooksA", "4Text BooksA"};
    String[] NameOfTheTextBooksBBrands = {"Select Name Of Item", "1Text BooksB", "2Text BooksB", "3Text BooksB", "4Text BooksB"};
    String[] NameOfTheTextBooksCBrands = {"Select Name Of Item", "1Text BooksC", "2Text BooksC", "3Text BooksC", "4Text BooksC"};
    String[] NameOfTheTextBooksDBrands = {"Select Name Of Item", "1Text BooksD", "2Text BooksD", "3Text BooksD", "4Text BooksD"};

    //Array for the Television Names
    String[] NameOfTheTelevisionABrands = {"Select Name Of Item", "1TelevisionA", "2TelevisionA", "3TelevisionA", "4TelevisionA"};
    String[] NameOfTheTelevisionBBrands = {"Select Name Of Item", "1TelevisionB", "2TelevisionB", "3TelevisionB", "4TelevisionB"};
    String[] NameOfTheTelevisionCBrands = {"Select Name Of Item", "1TelevisionC", "2TelevisionC", "3TelevisionC", "4TelevisionC"};
    String[] NameOfTheTelevisionDBrands = {"Select Name Of Item", "1TelevisionD", "2TelevisionD", "3TelevisionD", "4TelevisionD"};

    //Array for the Teddy Bear Names
    String[] NameOfTheTeddyBearABrands = {"Select Name Of Item", "1Teddy BearA", "2Teddy BearA", "3Teddy BearA", "4Teddy BearA"};
    String[] NameOfTheTeddyBearBBrands = {"Select Name Of Item", "1Teddy BearB", "2Teddy BearB", "3Teddy BearB", "4Teddy BearB"};
    String[] NameOfTheTeddyBearCBrands = {"Select Name Of Item", "1Teddy BearC", "2Teddy BearC", "3Teddy BearC", "4Teddy BearC"};
    String[] NameOfTheTeddyBearDBrands = {"Select Name Of Item", "1Teddy BearD", "2Teddy BearD", "3Teddy BearD", "4Teddy BearD"};

    //Array for the Video Games
    String[] NameOfTheVideoGamesABrands = {"Select Name Of Item", "1Video GamesA", "2Video GamesA", "3Video GamesA", "4Video GamesA"};
    String[] NameOfTheVideoGamesBBrands = {"Select Name Of Item", "1Video GamesB", "2Video GamesB", "3Video GamesB", "4Video GamesB"};
    String[] NameOfTheVideoGamesCBrands = {"Select Name Of Item", "1Video GamesC", "2Video GamesC", "3Video GamesC", "4Video GamesC"};
    String[] NameOfTheVideoGamesDBrands = {"Select Name Of Item", "1Video GamesD", "2Video GamesD", "3Video GamesD", "4Video GamesD"};

    //Array for the Water Bags Names
    String[] NameOfTheWaterBagsABrands = {"Select Name Of Item", "1Water BagsA", "2Water BagsA", "3Water BagsA", "4Water BagsA"};
    String[] NameOfTheWaterBagsBBrands = {"Select Name Of Item", "1Water BagsB", "2Water BagsB", "3Water BagsB", "4Water BagsB"};
    String[] NameOfTheWaterBagsCBrands = {"Select Name Of Item", "1Water BagsC", "2Water BagsC", "3Water BagsC", "4Water BagsC"};
    String[] NameOfTheWaterBagsDBrands = {"Select Name Of Item", "1Water BagsD", "2Water BagsD", "3Water BagsD", "4Water BagsD"};

    //Array for the Womens Fashion Names
    String[] NameOfTheWomensFashionABrands = {"Select Name Of Item", "1Women's FashionA", "2Women's FashionA", "3Women's FashionA", "4Women's FashionA"};
    String[] NameOfTheWomensFashionBBrands = {"Select Name Of Item", "1Women's FashionB", "2Women's FashionB", "3Women's FashionB", "4Women's FashionB"};
    String[] NameOfTheWomensFashionCBrands = {"Select Name Of Item", "1Women's FashionC", "2Women's FashionC", "3Women's FashionC", "4Women's FashionC"};
    String[] NameOfTheWomensFashionDBrands = {"Select Name Of Item", "1Women's FashionD", "2Women's FashionD", "3Women's FashionD", "4Women's FashionD"};

    //Array for the Webcam Names
    String[] NameOfTheWebcamABrands = {"Select Name Of Item", "1WebcamA", "2WebcamA", "3WebcamA", "4WebcamA"};
    String[] NameOfTheWebcamBBrands = {"Select Name Of Item", "1WebcamB", "2WebcamB", "3WebcamB", "4WebcamB"};
    String[] NameOfTheWebcamCBrands = {"Select Name Of Item", "1WebcamC", "2WebcamC", "3WebcamC", "4WebcamC"};
    String[] NameOfTheWebcamDBrands = {"Select Name Of Item", "1WebcamD", "2WebcamD", "3WebcamD", "4WebcamD"};
*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        spinnerTypeOfItem = (Spinner) findViewById(R.id.spinnerTypeOfItem);
        spinnerBrandOfItem = (Spinner) findViewById(R.id.spinnerBrandOfItem);
        //spinnerProductName = (Spinner) findViewById(R.id.spinnerProductName);
        editTextAreaOfRetailer = (EditText) findViewById(R.id.editTextAreaInAddItem);
        editTextNameOfItem = (EditText) findViewById(R.id.editTextProductName);
        editTextProductPrice = (EditText) findViewById(R.id.editTextProductPrice);
        editTextDescriptionOfItem = (EditText) findViewById(R.id.editTextDescriptionOfItem);
        editTextUsernameInAddItem = (EditText)findViewById(R.id.editTextUsernameInAddItem);
        editTextMobileNo = (EditText) findViewById(R.id.editTextMobileNoInAddItem);
        //spinnerAreaOfRetailer = (Spinner) findViewById(R.id.spinnerAreaInAddItem);
        buttonAddItem = (Button) findViewById(R.id.buttonAddItem);
        buttonUpdateItemInAddItemActivity = (Button) findViewById(R.id.buttonUpdateItemInAddItemActivity);
        imageViewInAddItemActivity = (ImageView) findViewById(R.id.imagesViewInAddItemActivity);

        //String Username = getIntent().getStringExtra("Username");

        String userName = getIntent().getStringExtra("UserName");

        idR = getIntent().getIntExtra("idOfItemZZZ", 1);
        String nameItemR = getIntent().getStringExtra("NameOfITem");
        String brandItemR = getIntent().getStringExtra("BrandOfITem");
        String areaR = getIntent().getStringExtra("AreaOfRetailer");
        descItemR = getIntent().getStringExtra("Desc");
        mobNoR = getIntent().getStringExtra("Mob");
        priceItemR = getIntent().getStringExtra("Price");
        usernameRetailerR = getIntent().getStringExtra("UsernameRetailer");
        UpdateIem = getIntent().getStringExtra("Update Item");

        String nameFromDesc = getIntent().getStringExtra("nameOfI");
        String usernameFromDesc = getIntent().getStringExtra("usernameOfI");
        String mobileFromDesc = getIntent().getStringExtra("mobileOfI");
        String priceFromDesc = getIntent().getStringExtra("priceOfI");
        String areaFromDesc = getIntent().getStringExtra("areaOfI");

        if (nameFromDesc != null){
            editTextNameOfItem.setText(nameFromDesc);
            editTextUsernameInAddItem.setText(usernameFromDesc);
            editTextMobileNo.setText(mobileFromDesc);
            editTextProductPrice.setText(priceFromDesc);
            editTextAreaOfRetailer.setText(areaFromDesc);
        }

        Server_Address_To_Store_Item = "http://192.168.43.35:80/kirana/add_item.php";
        Server_Address_To_Update_Item = "http://192.168.43.35:80/kirana/update_item.php?idOfItem="+idR;

        editTextDescriptionOfItem.setText(descItemR);

        if (usernameRetailerR != null) {
            editTextUsernameInAddItem.setText(usernameRetailerR);
            editTextMobileNo.setText(mobNoR);
            editTextNameOfItem.setText(nameItemR);
            editTextProductPrice.setText(priceItemR);
            editTextAreaOfRetailer.setText(areaR);
        } else if (userName != null){
            editTextUsernameInAddItem.setText(userName);
        }


        if (UpdateIem == null){
            buttonUpdateItemInAddItemActivity.setVisibility(View.INVISIBLE);
            buttonUpdateItemInAddItemActivity.setEnabled(false);
        } else {
            buttonAddItem.setVisibility(View.INVISIBLE);
            buttonAddItem.setEnabled(false);
        }

        spinnerTypeOfItem.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, typeOfItem));

        spinnerTypeOfItem.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                valueFromSpinnerTypeOfItem = spinnerTypeOfItem.getSelectedItem().toString();
                settingItemToBrandOfItemSpinner();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //valueFromSpinnerTypeOfItem = spinnerTypeOfItem.getSelectedItem().toString();
            }
        });

        spinnerBrandOfItem.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                valueFromSpinnerBrandOfItem = spinnerBrandOfItem.getSelectedItem().toString();
                //settingItemToNameOfTheProductSpinner();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        editTextDescriptionOfItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (spinnerTypeOfItem.getSelectedItem().toString().equals("Select Type of Item") ||
                        spinnerBrandOfItem.getSelectedItem().toString().equals("Select Brand Of Item") ||
                        editTextUsernameInAddItem.getText().toString().equals("") ||
                        editTextProductPrice.getText().toString().equals("")) {

                    Toast.makeText(AddItemActivity.this, "First Fill up above all fields", Toast.LENGTH_SHORT).show();

                } else {
                    String name, username, mobile, area, price;
                    name = editTextNameOfItem.getText().toString();
                    username = editTextUsernameInAddItem.getText().toString();
                    mobile = editTextMobileNo.getText().toString();
                    area = editTextAreaOfRetailer.getText().toString();
                    price = editTextProductPrice.getText().toString();

                    Intent intent = new Intent(AddItemActivity.this, DiscriptionOfItemActivity.class);
                    intent.putExtra("Type of the Item", valueFromSpinnerTypeOfItem);
                    intent.putExtra("name", name);
                    intent.putExtra("username", username);
                    intent.putExtra("mobile", mobile);
                    intent.putExtra("area", area);
                    intent.putExtra("price", price);
                    startActivity(intent);
                }

            }
        });

        buttonUpdateItemInAddItemActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap image = ((BitmapDrawable) imageViewInAddItemActivity.getDrawable()).getBitmap();
                username = editTextUsernameInAddItem.getText().toString();
                type_of_item = spinnerTypeOfItem.getSelectedItem().toString();
                brand_of_item = spinnerBrandOfItem.getSelectedItem().toString();
                //product_name = spinnerProductName.getSelectedItem().toString();
                product_name = editTextNameOfItem.getText().toString();
                area = editTextAreaOfRetailer.getText().toString();
                mobileNo = editTextMobileNo.getText().toString();
                price_of_item = editTextProductPrice.getText().toString();
                description_of_item = editTextDescriptionOfItem.getText().toString();
                checkUpdateOrAdd = "Update";

                new UploadItem(image, username, type_of_item, brand_of_item, product_name, price_of_item, description_of_item, area, mobileNo, checkUpdateOrAdd).execute();

                Intent intent = new Intent(AddItemActivity.this, ListOfItemCustomerActivity.class);
                intent.putExtra("username", username);
                startActivity(intent);

                //startActivity(new Intent(AddItemActivity.this, ListOfItemCustomerActivity.class));

            }
        });

        buttonAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap image = ((BitmapDrawable) imageViewInAddItemActivity.getDrawable()).getBitmap();
                username = editTextUsernameInAddItem.getText().toString();
                type_of_item = spinnerTypeOfItem.getSelectedItem().toString();
                brand_of_item = spinnerBrandOfItem.getSelectedItem().toString();
                //product_name = spinnerProductName.getSelectedItem().toString();
                product_name = editTextNameOfItem.getText().toString();
                area = editTextAreaOfRetailer.getText().toString();
                mobileNo = editTextMobileNo.getText().toString();
                price_of_item = editTextProductPrice.getText().toString();
                description_of_item = editTextDescriptionOfItem.getText().toString();
                checkUpdateOrAdd = null;

                new UploadItem(image, username, type_of_item, brand_of_item, product_name, price_of_item, description_of_item, area, mobileNo, checkUpdateOrAdd).execute();

                editTextProductPrice.setText(null);
                editTextNameOfItem.setText(null);
            }
        });

        imageViewInAddItemActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(
                        Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                startActivityForResult(i, RESULT_LOAD_IMAGE);
            }
        });


        fullDescriptionOfItem = getIntent().getStringExtra("Description Of Item");

        editTextDescriptionOfItem.setText(fullDescriptionOfItem);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = { MediaStore.Images.Media.DATA };

            Cursor cursor = getContentResolver().query(selectedImage,
                    filePathColumn, null, null, null);
            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();

            imageViewInAddItemActivity.setImageBitmap(BitmapFactory.decodeFile(picturePath));

        }
    }

    /*
    @Override
    public void onBackPressed() {
        if (UpdateIem == null){
            startActivity(new Intent(AddItemActivity.this, ListOfItemCustomerActivity.class));
        }
    }*/

    public class UploadItem extends AsyncTask<Void,Void,Void>{

        Bitmap image;
        String username;
        String type_of_item;
        String brand_of_item;
        String product_name;
        String price_of_item;
        String description_of_item;
        String area;
        String mobileNo;
        String checkingString;


        public UploadItem(Bitmap image, String username, String type_of_item, String brand_of_item, String product_name, String price_of_item, String description_of_item, String mobileOfRetailer, String areaOfRetailer, String checkingString) {
            this.image = image;
            this.username = username;
            this.type_of_item = type_of_item;
            this.brand_of_item = brand_of_item;
            this.product_name = product_name;
            this.price_of_item = price_of_item;
            this.description_of_item = description_of_item;
            this.mobileNo = mobileOfRetailer;
            this.area = areaOfRetailer;
            this.checkingString = checkingString;

            if (checkingString == null){
                urlDecided = Server_Address_To_Store_Item;
            } else {
                urlDecided = Server_Address_To_Update_Item;
            }
        }

        @Override
        protected Void doInBackground(Void... params) {

            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            image.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
            String encodedImage = Base64.encodeToString(byteArrayOutputStream.toByteArray(), Base64.DEFAULT);

            ArrayList<NameValuePair> dataToSend = new ArrayList<>();
            dataToSend.add(new BasicNameValuePair("username",username));
            dataToSend.add(new BasicNameValuePair("type",type_of_item));
            dataToSend.add(new BasicNameValuePair("brand",brand_of_item));
            dataToSend.add(new BasicNameValuePair("product_name",product_name));
            dataToSend.add(new BasicNameValuePair("price",price_of_item));
            dataToSend.add(new BasicNameValuePair("description",description_of_item));
            dataToSend.add(new BasicNameValuePair("mobile",mobileNo));
            dataToSend.add(new BasicNameValuePair("area",area));
            dataToSend.add(new BasicNameValuePair("image", encodedImage));

            HttpParams httpParams = getHttpRequestParams();

            HttpClient httpClient = new DefaultHttpClient(httpParams);

            HttpPost httpPost = new HttpPost(urlDecided);

            try {
                httpPost.setEntity(new UrlEncodedFormEntity(dataToSend));
                httpClient.execute(httpPost);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (ClientProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            Toast.makeText(AddItemActivity.this, "Data Added Successfully", Toast.LENGTH_SHORT).show();
        }
    }

    private HttpParams getHttpRequestParams(){
        HttpParams httpParams = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(httpParams, 1000 * 30);
        HttpConnectionParams.setSoTimeout(httpParams,1000*30);
        return null;
    }

/*
    private void settingItemToNameOfTheProductSpinner() {
        switch (valueFromSpinnerBrandOfItem) {
            case "BarbieA":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheBarbieABrands));
                break;
            case "BarbieB":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheBarbieBBrands));
                break;
            case "BarbieC":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheBarbieCBrands));
                break;
            case "BarbieD":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheBarbieDBrands));
                break;
            case "BluetoothA":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheBleutoothABrands));
                break;
            case "BluetoothB":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheBleutoothBBrands));
                break;
            case "BluetoothC":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheBleutoothCBrands));
                break;
            case "BluetoothD":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheBleutoothDBrands));
                break;
            case "CarToysA":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheCarToysABrands));
                break;
            case "CarToysB":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheCarToysBBrands));
                break;
            case "CarToysC":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheCarToysCBrands));
                break;
            case "CarToysD":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheCarToysDBrands));
                break;
            case "ChargerA":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheChargerABrands));
                break;
            case "ChargerB":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheChargerBBrands));
                break;
            case "ChargerC":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheChargerCBrands));
                break;
            case "ChargerD":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheChargerDBrands));
                break;
            case "Children's BooksA":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheChildrensBooksABrands));
                break;
            case "Children's BooksB":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheChildrensBooksBBrands));
                break;
            case "Children's BooksC":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheChildrensBooksCBrands));
                break;
            case "Children's BooksD":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheChildrensBooksDBrands));
                break;
            case "Children's FashionA":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheChildrensFashionABrands));
                break;
            case "Children's FashionB":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheChildrensFashionBBrands));
                break;
            case "Children's FashionC":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheChildrensFashionCBrands));
                break;
            case "Children's FashionD":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheChildrensFashionDBrands));
                break;
            case "ComputerA":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheComputerABrands));
                break;
            case "ComputerB":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheComputerBBrands));
                break;
            case "ComputerC":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheComputerCBrands));
                break;
            case "ComputerD":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheComputerDBrands));
                break;
            case "EarphoneA":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheEarphoneABrands));
                break;
            case "EarphoneB":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheEarphoneBBrands));
                break;
            case "EarphoneC":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheEarphoneCBrands));
                break;
            case "EarphoneD":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheEarphoneDBrands));
                break;
            case "FanA":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheFanABrands));
                break;
            case "FanB":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheFanBBrands));
                break;
            case "FanC":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheFanCBrands));
                break;
            case "FanD":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheFanDBrands));
                break;
            case "Gents WatchesA":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheGentsWatchABrands));
                break;
            case "Gents WatchesB":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheGentsWatchBBrands));
                break;
            case "Gents WatchesC":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheGentsWatchCBrands));
                break;
            case "Gents WatchesD":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheGentsWatchDBrands));
                break;
            case "HeadsetsA":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheHeadsetsABrands));
                break;
            case "HeadsetsB":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheHeadsetsBBrands));
                break;
            case "HeadsetsC":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheHeadsetsCBrands));
                break;
            case "HeadsetsD":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheHeadsetsDBrands));
                break;
            case "Home TheaterA":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheHomeTheaterABrands));
                break;
            case "Home TheaterB":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheHomeTheaterBBrands));
                break;
            case "Home TheaterC":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheHomeTheaterCBrands));
                break;
            case "Home TheaterD":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheHomeTheaterDBrands));
                break;
            case "Hard DisksA":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheHardDisksABrands));
                break;
            case "Hard DisksB":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheHardDisksBBrands));
                break;
            case "Hard DisksC":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheHardDisksCBrands));
                break;
            case "Hard DisksD":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheHardDisksDBrands));
                break;
            case "KeyboardA":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheKeyboardABrands));
                break;
            case "KeyboardB":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheKeyboardBBrands));
                break;
            case "KeyboardC":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheKeyboardCBrands));
                break;
            case "KeyboardD":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheKeyboardDBrands));
                break;
            case "LaptopA":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheLaptopABrands));
                break;
            case "LaptopB":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheLaptopBBrands));
                break;
            case "LaptopC":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheLaptopCBrands));
                break;
            case "LaptopD":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheLaptopDBrands));
                break;
            case "LaptopBatteryA":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheLaptopBatteryABrands));
                break;
            case "LaptopBatteryB":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheLaptopBatteryBBrands));
                break;
            case "LaptopBatteryC":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheLaptopBatteryCBrands));
                break;
            case "LaptopBatteryD":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheLaptopBatteryDBrands));
                break;
            case "Ladies WatchesA":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheLadiesWatchesABrands));
                break;
            case "Ladies WatchesB":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheLadiesWatchesBBrands));
                break;
            case "Ladies WatchesC":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheLadiesWatchesCBrands));
                break;
            case "Ladies WatchesD":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheLadiesWatchesDBrands));
                break;
            case "Light BulbsA":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheLightBulbsABrands));
                break;
            case "Light BulbsB":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheLightBulbsBBrands));
                break;
            case "Light BulbsC":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheLightBulbsCBrands));
                break;
            case "Light BulbsD":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheLightBulbsDBrands));
                break;
            case "MagzinesA":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheMagzinesABrands));
                break;
            case "MagzinesB":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheMagzinesBBrands));
                break;
            case "MagzinesC":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheMagzinesCBrands));
                break;
            case "MagzinesD":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheMagzinesDBrands));
                break;
            case "MobileA":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheMobileABrands));
                break;
            case "MobileB":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheMobileBBrands));
                break;
            case "MobileC":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheMobileCBrands));
                break;
            case "MobileD":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheMobileDBrands));
                break;
            case "Mobile BatteryA":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheMobileBatteryABrands));
                break;
            case "Mobile BatteryB":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheMobileBatteryBBrands));
                break;
            case "Mobile BatteryC":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheMobileBatteryCBrands));
                break;
            case "Mobile BatteryD":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheMobileBatteryDBrands));
                break;
            case "Men's FashionA":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheMensFashionABrands));
                break;
            case "Men's FashionB":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheMensFashionBBrands));
                break;
            case "Men's FashionC":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheMensFashionCBrands));
                break;
            case "Men's FashionD":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheMensFashionDBrands));
                break;
            case "MotherboardA":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheMotherboardABrands));
                break;
            case "MotherboardB":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheMotherboardBBrands));
                break;
            case "MotherboardC":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheMotherboardCBrands));
                break;
            case "MotherboardD":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheMotherboardDBrands));
                break;
            case "Movies CDsA":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheMoviesCDsABrands));
                break;
            case "Movies CDsB":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheMoviesCDsBBrands));
                break;
            case "Movies CDsC":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheMoviesCDsCBrands));
                break;
            case "Movies CDsD":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheMoviesCDsDBrands));
                break;
            case "Movies DVDsA":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheMoviesDVDsABrands));
                break;
            case "Movies DVDsB":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheMoviesDVDsBBrands));
                break;
            case "Movies DVDsC":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheMoviesDVDsCBrands));
                break;
            case "Movies DVDsD":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheMoviesDVDsDBrands));
                break;
            case "Music CDsA":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheMusicCDsABrands));
                break;
            case "Music CDsB":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheMusicCDsBBrands));
                break;
            case "Music CDsC":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheMusicCDsCBrands));
                break;
            case "Music CDsD":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheMusicCDsDBrands));
                break;
            case "Music DVDsA":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheMusicDVDsABrands));
                break;
            case "Music DVDsB":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheMusicDVDsBBrands));
                break;
            case "Music DVDsC":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheMusicDVDsCBrands));
                break;
            case "Music DVDsD":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheMusicDVDsDBrands));
                break;
            case "Note BooksA":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheNoteBooksABrands));
                break;
            case "Note BooksB":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheNoteBooksBBrands));
                break;
            case "Note BooksC":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheNoteBooksCBrands));
                break;
            case "Note BooksD":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheNoteBooksDBrands));
                break;
            case "Other BooksA":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheOtherBooksABrands));
                break;
            case "Other BooksB":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheOtherBooksBBrands));
                break;
            case "Other BooksC":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheOtherBooksCBrands));
                break;
            case "Other BooksD":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheOtherBooksDBrands));
                break;
            case "MouseA":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheMouseABrands));
                break;
            case "MouseB":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheMouseBBrands));
                break;
            case "MouseC":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheMouseCBrands));
                break;
            case "MouseD":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheMouseDBrands));
                break;
            case "OvenA":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheOvenABrands));
                break;
            case "OvenB":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheOvenBBrands));
                break;
            case "OvenC":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheOvenCBrands));
                break;
            case "OvenD":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheOvenDBrands));
                break;
            case "Pen DriveA":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfThePenDriveABrands));
                break;
            case "Pen DriveB":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfThePenDriveBBrands));
                break;
            case "Pen DriveC":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfThePenDriveCBrands));
                break;
            case "Pen DriveD":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfThePenDriveDBrands));
                break;
            case "PensA":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfThePenABrands));
                break;
            case "PensB":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfThePenBBrands));
                break;
            case "PensC":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfThePenCBrands));
                break;
            case "PensD":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfThePenDBrands));
                break;
            case "RefrigeratorA":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheRefrigeratorABrands));
                break;
            case "RefrigeratorB":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheRefrigeratorBBrands));
                break;
            case "RefrigeratorC":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheRefrigeratorCBrands));
                break;
            case "RefrigeratorD":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheRefrigeratorDBrands));
                break;
            case "Smart WatchesA":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheSmartWatchesABrands));
                break;
            case "Smart WatchesB":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheSmartWatchesBBrands));
                break;
            case "Smart WatchesC":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheSmartWatchesCBrands));
                break;
            case "Smart WatchesD":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheSmartWatchesDBrands));
                break;
            case "SpeakerA":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheSpeakerABrands));
                break;
            case "SpeakerB":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheSpeakerBBrands));
                break;
            case "SpeakerC":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheSpeakerCBrands));
                break;
            case "SpeakerD":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheSpeakerDBrands));
                break;
            case "Sports ShoesA":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheSportsShoesABrands));
                break;
            case "Sports ShoesB":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheSportsShoesBBrands));
                break;
            case "Sports ShoesC":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheSportsShoesCBrands));
                break;
            case "Sports ShoesD":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheSportsShoesDBrands));
                break;
            case "ShoesA":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheShoesABrands));
                break;
            case "ShoesB":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheShoesBBrands));
                break;
            case "ShoesC":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheShoesCBrands));
                break;
            case "ShoesD":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheShoesDBrands));
                break;
            case "SandalA":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheSandalABrands));
                break;
            case "SandalB":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheSandalBBrands));
                break;
            case "SandalC":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheSandalCBrands));
                break;
            case "SandalD":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheSandalDBrands));
                break;
            case "SlippersA":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheSlippersABrands));
                break;
            case "SlippersB":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheSlippersBBrands));
                break;
            case "SlippersC":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheSlippersCBrands));
                break;
            case "SlippersD":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheSlippersDBrands));
                break;
            case "School BagsA":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheSchoolBagsABrands));
                break;
            case "School BagsB":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheSchoolBagsBBrands));
                break;
            case "School BagsC":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheSchoolBagsCBrands));
                break;
            case "School BagsD":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheSchoolBagsDBrands));
                break;
            case "TabletsA":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheTabletsABrands));
                break;
            case "TabletsB":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheTabletsBBrands));
                break;
            case "TabletsC":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheTabletsCBrands));
                break;
            case "TabletsD":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheTabletsDBrands));
                break;
            case "TiffinA":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheTiffinABrands));
                break;
            case "TiffinB":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheTiffinBBrands));
                break;
            case "TiffinC":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheTiffinCBrands));
                break;
            case "TiffinD":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheTiffinDBrands));
                break;
            case "Text BooksA":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheTextBooksABrands));
                break;
            case "Text BooksB":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheTextBooksBBrands));
                break;
            case "Text BooksC":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheTextBooksCBrands));
                break;
            case "Text BooksD":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheTextBooksDBrands));
                break;
            case "TelevisionA":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheTelevisionABrands));
                break;
            case "TelevisionB":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheTelevisionBBrands));
                break;
            case "TelevisionC":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheTelevisionCBrands));
                break;
            case "TelevisionD":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheTelevisionDBrands));
                break;
            case "Teddy BearA":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheTeddyBearABrands));
                break;
            case "Teddy BearB":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheTeddyBearBBrands));
                break;
            case "Teddy BearC":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheTeddyBearCBrands));
                break;
            case "Teddy BearD":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheTeddyBearDBrands));
                break;
            case "Video GamesA":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheVideoGamesABrands));
                break;
            case "Video GamesB":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheVideoGamesBBrands));
                break;
            case "Video GamesC":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheVideoGamesCBrands));
                break;
            case "Video GamesD":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheVideoGamesDBrands));
                break;
            case "Water BagsA":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheWaterBagsABrands));
                break;
            case "Water BagsB":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheWaterBagsBBrands));
                break;
            case "Water BagsC":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheWaterBagsCBrands));
                break;
            case "Water BagsD":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheWaterBagsDBrands));
                break;
            case "Women's FashionA":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheWomensFashionABrands));
                break;
            case "Women's FashionB":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheWomensFashionBBrands));
                break;
            case "Women's FashionC":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheWomensFashionCBrands));
                break;
            case "Women's FashionD":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheWomensFashionDBrands));
                break;
            case "WebcamA":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheWebcamABrands));
                break;
            case "WebcamB":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheWebcamBBrands));
                break;
            case "WebcamC":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheWebcamCBrands));
                break;
            case "WebcamD":
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NameOfTheWebcamDBrands));
                break;
            default:
                spinnerProductName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, defaultValueOfNameOfItem));
                break;
        }


    }
*/

    private void settingItemToBrandOfItemSpinner() {
        switch (valueFromSpinnerTypeOfItem) {
            case "Bluetooth":
                spinnerBrandOfItem.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, BluetoothBrands));
                break;
            case "Barbie":
                spinnerBrandOfItem.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, BarbieBrands));
                break;
            case "Car Toys":
                spinnerBrandOfItem.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, CarToysBrands));
                break;
            case "Charger":
                spinnerBrandOfItem.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, ChargerBrands));
                break;
            case "Children's Books":
                spinnerBrandOfItem.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, ChildrensBooksBrands));
                break;
            case "Children's Fashion":
                spinnerBrandOfItem.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, ChildrensFashionBrands));
                break;
            case "Earphone":
                spinnerBrandOfItem.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, EarphoneBrands));
                break;
            case "Fan":
                spinnerBrandOfItem.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, FanBrands));
                break;
            case "Gents Watches":
                spinnerBrandOfItem.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, GentsWatchesBrands));
                break;
            case "Headsets":
                spinnerBrandOfItem.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, HeadsetsBrands));
                break;
            case "Home Theater":
                spinnerBrandOfItem.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, HomeTheaterBrands));
                break;
            case "Hard Disks":
                spinnerBrandOfItem.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, HardDisksBrands));
                break;
            case "Keyboard":
                spinnerBrandOfItem.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, KeyboardBrands));
                break;
            case "Laptop":
                spinnerBrandOfItem.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, LaptopBrands));
                break;
            case "Laptop Battery":
                spinnerBrandOfItem.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, LaptopBatteryBrands));
                break;
            case "Light Bulbs":
                spinnerBrandOfItem.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, LightBulbsBrands));
                break;
            case "Computer":
                spinnerBrandOfItem.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, ComputerBrands));
                break;
            case "Ladies Watches":
                spinnerBrandOfItem.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, LadiesWatchesBrands));
                break;
            case "Magzines":
                spinnerBrandOfItem.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, MagzinesBrands));
                break;
            case "Mobiles":
                spinnerBrandOfItem.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, MobileBrands));
                break;
            case "Mobile Battery":
                spinnerBrandOfItem.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, MobileBatteryBrands));
                break;
            case "Men's Fashion":
                spinnerBrandOfItem.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, MensFashionBrands));
                break;
            case "Motherboard":
                spinnerBrandOfItem.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, MotherboardBrands));
                break;
            case "Mouse":
                spinnerBrandOfItem.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, MouseBrands));
                break;
            case "Movies CDs":
                spinnerBrandOfItem.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, MoviesCDsBrands));
                break;
            case "Music CDs":
                spinnerBrandOfItem.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, MusicCDsBrands));
                break;
            case "Movies DVDs":
                spinnerBrandOfItem.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, MoviesDVDsBrands));
                break;
            case "Note Books":
                spinnerBrandOfItem.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NoteBooksBrands));
                break;
            case "Other Books":
                spinnerBrandOfItem.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, OtherBooksBrands));
                break;
            case "Oven":
                spinnerBrandOfItem.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, OvenBrands));
                break;
            case "Pen Drive":
                spinnerBrandOfItem.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, PenDriveBrands));
                break;
            case "Pens":
                spinnerBrandOfItem.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, PensBrands));
                break;
            case "Refrigerator":
                spinnerBrandOfItem.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, RefrigeratorBrands));
                break;
            case "Smart Watches":
                spinnerBrandOfItem.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, SmartWatchesBrands));
                break;
            case "Speaker":
                spinnerBrandOfItem.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, SpeakerBrands));
                break;
            case "Sports Shoes":
                spinnerBrandOfItem.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, SportsShoesBrands));
                break;
            case "Shoes":
                spinnerBrandOfItem.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, ShoesBrands));
                break;
            case "Sandal":
                spinnerBrandOfItem.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, SandalBrands));
                break;
            case "Slippers":
                spinnerBrandOfItem.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, SlippersBrands));
                break;
            case "School Bags":
                spinnerBrandOfItem.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, SchoolBagsBrands));
                break;
            case "Tiffin":
                spinnerBrandOfItem.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, TiffinBrands));
                break;
            case "Text Books":
                spinnerBrandOfItem.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, TextBooksBrands));
                break;
            case "Tablets":
                spinnerBrandOfItem.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, TabletsBrands));
                break;
            case "Television":
                spinnerBrandOfItem.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, TelevisionBrands));
                break;
            case "Teddy Bear":
                spinnerBrandOfItem.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, TeddyBearBrands));
                break;
            case "Video Games":
                spinnerBrandOfItem.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, VideoGamesBrands));
                break;
            case "Webcam":
                spinnerBrandOfItem.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, WebcamBrands));
                break;
            case "Water Bags":
                spinnerBrandOfItem.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, WaterBagsBrands));
                break;
            default:
                spinnerBrandOfItem.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, defaultValueOfBrandOfItem));
                break;
        }
    }
}
