package com.igrayuvminecraftkakbozhenka.superapp.data.db;

import com.igrayuvminecraftkakbozhenka.superapp.models.ImtModel;

import java.util.ArrayList;
import java.util.List;

public interface DataBase {

    void setData(ImtModel imtModel);
    List<ImtModel> getData();
}
