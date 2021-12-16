package com.bilgeadam;

import com.bilgeadam.controller.ArtistController;
import com.bilgeadam.controller.DvdController;
import com.bilgeadam.model.*;
import com.bilgeadam.utils.BAUtils;

public class ConsoleMain {
    private static AdminCrudOperations adminCrudOperations = AdminCrudOperations.getInstance();
    private static BAUtils baUtils = BAUtils.getInstance();


    public static void main(String[] args) {
        baUtils.header("Müzik Markete Hoşgeldiniz");
        adminCrudOperations.showMainMenu();
    }
}
