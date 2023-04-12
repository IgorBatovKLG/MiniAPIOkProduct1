package com.example.miniapiokproduct.service;

import com.example.miniapiokproduct.dataBase.TelegramDatabase;
import com.example.miniapiokproduct.garbage.countViews;

public class TelegramService {

    public void addDb(int count, int type) {
        TelegramDatabase telegramDatabase = new TelegramDatabase();
        if (type == 1) {
            for (int i = 0; i < countViews.list().size(); i++) {
                double randomValue = Math.random();
                double x = 1;
                if (randomValue <= 0.7) {
                    x = 0.7;
                }
                ;
                if (randomValue <= 0.5) {
                    x = 0.9;
                }
                ;
                if (randomValue <= 0.3) {
                    x = 1.1;
                }
                ;
                if (randomValue <= 0.1) {
                    x = 1.2;
                }
                ;
                double v = countViews.list().get(i).getCount() * count / 100 * x;
                if (v > 1) {
                    if (v < 3) {
                        if (randomValue <= 0.9) {
                            v = 3.0;
                        }
                        ;
                        if (randomValue <= 0.7) {
                            v = 5.0;
                        }
                        ;
                        if (randomValue <= 0.5) {
                            v = 1.0;
                        }
                        ;
                        if (randomValue <= 0.3) {
                            v = 2.0;
                        }
                        ;
                        if (randomValue <= 0.1) {
                            v = 0.0;
                        }
                        ;
                        System.out.println(Double.valueOf(v).intValue() + " - " + i + " - " + randomValue);
                    } else {
                        System.out.println(Double.valueOf(v).intValue() + " - " + i + " - " + randomValue);
                    }
                } else {
                    double probability = 0.1;
                    if (randomValue <= probability) {
                        System.out.println(1 + " - " + i + " - " + randomValue);
                    }
                }
            }
        }
        if (type == 2){
            count = (int) (count * 0.1);
            for (int i = 0; i < 48; i++) {
                double randomValue = Math.random();
                double x = 1;
                if (randomValue <= 0.7) {
                    x = 0.7;
                }
                ;
                if (randomValue <= 0.5) {
                    x = 0.9;
                }
                ;
                if (randomValue <= 0.3) {
                    x = 1.1;
                }
                ;
                if (randomValue <= 0.1) {
                    x = 1.2;
                }
                ;
                double v = countViews.list().get(i).getCount() * count / 100 * x;
                if (v > 1) {
                    if (v < 3) {
                        if (randomValue <= 0.9) {
                            v = 3.0;
                        }
                        ;
                        if (randomValue <= 0.7) {
                            v = 5.0;
                        }
                        ;
                        if (randomValue <= 0.5) {
                            v = 1.0;
                        }
                        ;
                        if (randomValue <= 0.3) {
                            v = 2.0;
                        }
                        ;
                        if (randomValue <= 0.1) {
                            v = 0.0;
                        }
                        ;
                        System.out.println(Double.valueOf(v).intValue() + " - " + i + " - " + randomValue);
                    } else {
                        System.out.println(Double.valueOf(v).intValue() + " - " + i + " - " + randomValue);
                    }
                } else {
                    double probability = 0.1;
                    if (randomValue <= probability) {
                        System.out.println(1 + " - " + i + " - " + randomValue);
                    }
                }
            }
        }
    }

}
