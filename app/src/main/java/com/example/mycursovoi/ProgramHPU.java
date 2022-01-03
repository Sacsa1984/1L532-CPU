package com.example.mycursovoi;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class ProgramHPU {
    public String[] G_Cod;
    public String[] M_Cod;
    public String S_Dan;
    public String T_Dan;
    public String H_Dan;
    public String[] F_Dan;
    public float ANG;
    int n;
    String StrokHPU;
    public Model_Vhod_Dan Model_dan;


    public ProgramHPU() {
        G_Cod = new String[]{"G0", "G1", "G2"};
        M_Cod = new String[]{"M41", "M42", "M43", "M44", "M03", "M04", "M00", "M30"};
        F_Dan = new String[]{"F0.9", "F1", "F1.1", "F1.5"};

    }

    public String getStrokHPU() {
        return StrokHPU;
    }

    public void setStrokHPU(String strokHPU) {
        StrokHPU = strokHPU;
    }

    public String getS_Dan() {
        return S_Dan;
    }

    public void setS_Dan(String s_Dan) {
        S_Dan = s_Dan;
    }

    public String getT_Dan() {
        return T_Dan;
    }

    public void setT_Dan(String t_Dan) {
        T_Dan = t_Dan;
    }

    public String getH_Dan() {
        return H_Dan;
    }

    public void setH_Dan(String h_Dan) {
        H_Dan = h_Dan;
    }

    public String[] getG_Cod() {
        return G_Cod;
    }

    public void setG_Cod(String[] g_Cod) {
        G_Cod = g_Cod;
    }

    public String[] getM_Cod() {
        return M_Cod;
    }

    public void setM_Cod(String[] m_Cod) {
        M_Cod = m_Cod;
    }

    public String[] getF_Dan() {
        return F_Dan;
    }

    public void setF_Dan(String[] f_Dan) {
        F_Dan = f_Dan;
    }

    public float getANG() {
        return ANG;
    }

    public void setANG(float ANG) {
        this.ANG = ANG;
    }



    public String Torec(Model_Vhod_Dan Dan_PR, int S, int M) {
         StrokHPU = null;
        n = 5;

        StrokHPU = "N" + n;
        StrokHPU += " " + M_Cod[M];
        StrokHPU += " " + M_Cod[5];
        StrokHPU += " S" + S;
        StrokHPU += " T" + Dan_PR.T_Instrument;
        StrokHPU += " H" + Dan_PR.H_Instrument;
        StrokHPU += "\n";

        if (Dan_PR.Napravlenie == 1) {
            n += 5;
            StrokHPU += "N" + n + " " + G_Cod[0] + " Z" + (Dan_PR.Pripusk + 5);
            StrokHPU += "\n";
            n += 5;
            StrokHPU += "N" + n + " " + " X" + (Dan_PR.D_Det - 5);
            StrokHPU += "\n";
            n += 5;
            StrokHPU += "N" + n + " " + G_Cod[1] + " Z" + (Dan_PR.Pripusk) + " X" + Dan_PR.D_Det + " " + F_Dan[3];
            StrokHPU += "\n";
            Dan_PR.L_Obrabotka *= 2;

            if (Dan_PR.Pripusk > 4) {
                for (int i = 4; Dan_PR.Pripusk > i; i += 4) {
                    if (Dan_PR.Pripusk - i > 0) {

                        n += 5;
                        StrokHPU += "N" + n + " " + G_Cod[1] + " Z" + (Dan_PR.Pripusk - i) + " " + F_Dan[3];
                        StrokHPU += "\n";
                        n += 5;
                        StrokHPU += "N" + n + " "  + " X" + (Dan_PR.D_Det + Dan_PR.L_Obrabotka) + " " + F_Dan[0];
                        StrokHPU += "\n";;
                        n += 5;
                        StrokHPU += "N" + n + " " + G_Cod[0] + " X" + (Dan_PR.D_Det - 5);
                        StrokHPU += "\n";


                    } else {

                        n += 5;
                        StrokHPU += "N" + n + " " + G_Cod[1] + " Z" + (Dan_PR.Pripusk - i) + " " + F_Dan[3];
                        StrokHPU += "\n";
                        n += 5;
                        StrokHPU += "N" + n + " "  + " X" + (Dan_PR.D_Det + Dan_PR.L_Obrabotka) + " " + F_Dan[0];
                        StrokHPU += "\n";
                        n += 5;
                        StrokHPU += "N" + n + " " + G_Cod[0] + " X" + (Dan_PR.D_Det - 5);
                        StrokHPU += "\n";
                        n += 5;
                        StrokHPU += "N" + n + " " + G_Cod[1] + " Z" + 0 + " " + F_Dan[3];
                        StrokHPU += "\n";
                        n += 5;
                        StrokHPU += "N" + n + " "  + " X" + (Dan_PR.D_Det + Dan_PR.L_Obrabotka) + " " + F_Dan[0];
                        StrokHPU += "\n";
                    }

                }
            }

            n += 5;
            StrokHPU += "N" + n + " " + G_Cod[1] + " Z" + 0 + " " + F_Dan[3];
            StrokHPU += "\n";
            n += 5;
            StrokHPU += "N" + n + " "  + " X" + (Dan_PR.D_Det + Dan_PR.L_Obrabotka) + " " + F_Dan[0];
            StrokHPU += "\n";
            n += 5;
            StrokHPU += "N" + n + " " + G_Cod[0] + " Z" + (Dan_PR.Pripusk + 5);
            StrokHPU += "\n";
            n += 5;
            StrokHPU += "N" + n + " "  + " X" + (Dan_PR.D_Det - 5);
            StrokHPU += "\n";
            n += 5;
            StrokHPU += "N" + n + " " + M_Cod[6];
            StrokHPU += "\n";
            n += 5;
            StrokHPU += "N" + n + " " + M_Cod[7];
            StrokHPU += "\n";


        } else {


            n += 5;
            StrokHPU += "N" + n + " " + G_Cod[0] + " Z" + (Dan_PR.Pripusk + 5);
            StrokHPU += "\n";
            n += 5;
            StrokHPU += "N" + n + " "  + " X" + (Dan_PR.D_Det + 5);
            StrokHPU += "\n";
            n += 5;
            StrokHPU += "N" + n + " " + G_Cod[1] + " Z" + (Dan_PR.Pripusk) + " X" + Dan_PR.D_Det + " " + F_Dan[3];
            StrokHPU += "\n";
            Dan_PR.L_Obrabotka *= 2;

            if (Dan_PR.Pripusk > 4) {
                for (int i = 4; Dan_PR.Pripusk > i; i += 4) {
                    if (Dan_PR.Pripusk - i > 0) {

                        n += 5;
                        StrokHPU += "N" + n + " " + G_Cod[1] + " Z" + (Dan_PR.Pripusk - i) + " " + F_Dan[3];
                        StrokHPU += "\n";
                        n += 5;
                        StrokHPU += "N" + n + " "  + " X" + (Dan_PR.D_Det - Dan_PR.L_Obrabotka) + " " + F_Dan[0];
                        StrokHPU += "\n";
                        n += 5;
                        StrokHPU += "N" + n + " " + G_Cod[0] + " X" + (Dan_PR.D_Det + 5);
                        StrokHPU += "\n";


                    } else {

                        n += 5;
                        StrokHPU += "N" + n + " " + G_Cod[1] + " Z" + (Dan_PR.Pripusk - i) + " " + F_Dan[3];
                        StrokHPU += "\n";
                        n += 5;
                        StrokHPU += "N" + n + " "  + " X" + (Dan_PR.D_Det - Dan_PR.L_Obrabotka) + " " + F_Dan[0];
                        StrokHPU += "\n";
                        n += 5;
                        StrokHPU += "N" + n + " " + G_Cod[0] + " X" + (Dan_PR.D_Det + 5);
                        StrokHPU += "\n";
                        n += 5;
                        StrokHPU += "N" + n + " " + G_Cod[1] + " Z" + 0 + " " + F_Dan[3];
                        StrokHPU += "\n";
                        n += 5;
                        StrokHPU += "N" + n + " "  + " X" + (Dan_PR.D_Det - Dan_PR.L_Obrabotka) + " " + F_Dan[0];
                        StrokHPU += "\n";
                    }

                }
            }

            n += 5;
            StrokHPU += "N" + n + " " + G_Cod[1] + " Z" + 0 + " " + F_Dan[3];
            StrokHPU += "\n";
            n += 5;
            StrokHPU += "N" + n + " "  + " X" + (Dan_PR.D_Det - Dan_PR.L_Obrabotka) + " " + F_Dan[0];
            StrokHPU += "\n";
            n += 5;
            StrokHPU += "N" + n + " " + G_Cod[0] + " Z" + (Dan_PR.Pripusk + 5);
            StrokHPU += "\n";
            n += 5;
            StrokHPU += "N" + n + " "  + " X" + (Dan_PR.D_Det + 5);
            StrokHPU += "\n";
            n += 5;
            StrokHPU += "N" + n + " " + M_Cod[6];
            StrokHPU += "\n";
            n += 5;
            StrokHPU += "N" + n + " " + M_Cod[7];



        }

        return  StrokHPU;
    }


    public String VN_D_Obra(Model_Vhod_Dan Dan_PR, int S, int M )
    {
         StrokHPU = null;

         n = 5;

            if(Dan_PR.ANG==0) {
                StrokHPU = "N" + n;
                StrokHPU += " " + M_Cod[M];
                StrokHPU += " " + M_Cod[5];
                StrokHPU += " S" + S;
                StrokHPU += " T" + Dan_PR.T_Instrument;
                StrokHPU += " H" + Dan_PR.H_Instrument;
                StrokHPU += "\n";
                n += 5;
                StrokHPU += "N" + n + " " + G_Cod[0] + " Z" + 5;
                StrokHPU += "\n";
                n += 5;
                StrokHPU += "N" + n + " " + " X" + (Dan_PR.D_Det - Dan_PR.Pripusk - 5);
                StrokHPU += "\n";
                n += 5;
                StrokHPU += "N" + n + " " + G_Cod[1] + " Z" + 0 + " X" + (Dan_PR.D_Det - Dan_PR.Pripusk) + " " + F_Dan[3];
                StrokHPU += "\n";

                if (Dan_PR.Pripusk > 8) {
                    for (int i = 8; Dan_PR.Pripusk > i; i += 8) {
                        if (Dan_PR.Pripusk - i > 0) {
                            n += 5;
                            StrokHPU += "N" + n + " "  + " X" + (Dan_PR.D_Det - (Dan_PR.Pripusk - i)) + " " + F_Dan[1];
                            StrokHPU += "\n";
                            n += 5;
                            StrokHPU += "N" + n + " " + G_Cod[1] + " Z-" + (Dan_PR.L_Obrabotka) + " " + F_Dan[1];
                            StrokHPU += "\n";
                            n += 5;
                            StrokHPU += "N" + n + " " + G_Cod[0] + " Z" + 0;
                            StrokHPU += "\n";

                        }
                        else {
                            n += 5;
                            StrokHPU += "N" + n + " " + G_Cod[1] + " X" + Dan_PR.D_Det;
                            StrokHPU += "\n";
                            n += 5;
                            StrokHPU += "N" + n + " "  + " Z-" + (Dan_PR.L_Obrabotka) + " " + F_Dan[1];
                            StrokHPU += "\n";
                            n += 5;
                            StrokHPU += "N" + n + " " + G_Cod[0] + " X" + (Dan_PR.D_Det - 5) ;
                            StrokHPU += "\n";
                            n += 5;
                            StrokHPU += "N" + n + " "  + " Z" + 0;
                            StrokHPU += "\n";

                        }
                    }
                }
                    n += 5;
                    StrokHPU += "N" + n + " " + G_Cod[1] + " X" + Dan_PR.D_Det;
                    StrokHPU += "\n";
                    n += 5;
                    StrokHPU += "N" + n + " "  + " Z-" + (Dan_PR.L_Obrabotka) + " " + F_Dan[1];
                    StrokHPU += "\n";
                    n += 5;
                    StrokHPU += "N" + n + " " + G_Cod[0] + " X" + (Dan_PR.D_Det - 5);
                    StrokHPU += "\n";
                    n += 5;
                    StrokHPU += "N" + n + " "  + " Z" + 0;
                    StrokHPU += "\n";
                    n += 5;
                    StrokHPU += "N" + n + " " + M_Cod[6];
                    StrokHPU += "\n";
                    n += 5;
                    StrokHPU += "N" + n + " " + M_Cod[7];
                    StrokHPU += "\n";




            }

            if(Dan_PR.ANG!=0) {

                ANG=180+Dan_PR.ANG;
                if(ANG>180) {
                    StrokHPU = "N" + n;
                    StrokHPU += " " + M_Cod[M];
                    StrokHPU += " " + M_Cod[5];
                    StrokHPU += " S" + S;
                    StrokHPU += " T" + Dan_PR.T_Instrument;
                    StrokHPU += " H" + Dan_PR.H_Instrument;
                    StrokHPU += "\n";
                    n += 5;
                    StrokHPU += "N" + n + " " + G_Cod[0] + " Z" + 5;
                    StrokHPU += "\n";
                    n += 5;
                    StrokHPU += "N" + n + " "  + " X" + (Dan_PR.D_Det - Dan_PR.Pripusk - 5);
                    StrokHPU += "\n";
                    n += 5;
                    StrokHPU += "N" + n + " " + G_Cod[1] + " Z" + 0 + " X" + (Dan_PR.D_Det - Dan_PR.Pripusk) + " " + F_Dan[3];
                    StrokHPU += "\n";

                    if (Dan_PR.Pripusk > 8) {
                        for (int i = 8; Dan_PR.Pripusk > i; i += 8) {
                            if (Dan_PR.Pripusk - i > 0) {
                                n += 5;
                                StrokHPU += "N" + n + " " + G_Cod[1] + " X" + (Dan_PR.D_Det - (Dan_PR.Pripusk - i)) + " " + F_Dan[1];
                                StrokHPU += "\n";
                                n += 5;
                                StrokHPU += "N" + n + " "  + " " + "ANG=" + ANG + " " + " Z-" + (Dan_PR.L_Obrabotka) + " " + F_Dan[1];
                                StrokHPU += "\n";

                                n += 5;
                                StrokHPU += "N" + n + " " + G_Cod[0] + " Z" + 0;
                                StrokHPU += "\n";
                                n += 5;
                                StrokHPU += "N" + n + " "  + " X" + (Dan_PR.D_Det - Dan_PR.Pripusk + i - 5);
                                StrokHPU += "\n";


                            } else {

                                n += 5;
                                StrokHPU += "N" + n + " " + G_Cod[1] + " X" + Dan_PR.D_Det;
                                StrokHPU += "\n";
                                n += 5;
                                StrokHPU += "N" + n + " "  + " " + "ANG=" + ANG + " " + " Z-" + (Dan_PR.L_Obrabotka) + " " + F_Dan[1];
                                StrokHPU += "\n";
                                n += 5;
                                StrokHPU += "N" + n + " " + G_Cod[0] + " Z" + 0;
                                StrokHPU += "\n";

                            }
                        }
                    }
                        n += 5;
                        StrokHPU += "N" + n + " " + G_Cod[1] + " X" + Dan_PR.D_Det + " " + F_Dan[1];
                        StrokHPU += "\n";
                        n += 5;
                        StrokHPU += "N" + n + " " + " " + "ANG=" + ANG + " " + " Z-" + (Dan_PR.L_Obrabotka) + " " + F_Dan[1];
                        StrokHPU += "\n";
                        n += 5;
                        StrokHPU += "N" + n + " " + G_Cod[0] + " Z" + 0;
                        StrokHPU += "\n";
                        n += 5;
                        StrokHPU += "N" + n + " " + M_Cod[6];
                        StrokHPU += "\n";
                        n += 5;
                        StrokHPU += "N" + n + " " + M_Cod[7];



                }
                if(ANG<180) {
                    StrokHPU = "N" + n;
                    StrokHPU += " " + M_Cod[M];
                    StrokHPU += " " + M_Cod[5];
                    StrokHPU += " S" + S;
                    StrokHPU += " T" + Dan_PR.T_Instrument;
                    StrokHPU += " H" + Dan_PR.H_Instrument;
                    StrokHPU += "\n";
                    n += 5;
                    StrokHPU += "N" + n + " " + G_Cod[0] + " Z" + 5;
                    StrokHPU += "\n";
                    n += 5;
                    StrokHPU += "N" + n + " "  + " X" + (Dan_PR.D_Det - Dan_PR.Pripusk - 5);
                    StrokHPU += "\n";
                    n += 5;
                    StrokHPU += "N" + n + " " + G_Cod[1] + " Z" + 0 + " X" + (Dan_PR.D_Det - Dan_PR.Pripusk) + " " + F_Dan[3];
                    StrokHPU += "\n";

                    if (Dan_PR.Pripusk > 8) {
                        for (int i = 8; Dan_PR.Pripusk > i; i += 8) {
                            if (Dan_PR.Pripusk - i > 0) {
                                n += 5;
                                StrokHPU += "N" + n + " " + G_Cod[1] + " X" + (Dan_PR.D_Det - (Dan_PR.Pripusk - i)) + " " + F_Dan[1];
                                StrokHPU += "\n";
                                n += 5;
                                StrokHPU += "N" + n + " "  + " " + "ANG=" + ANG + " " + " Z-" + (Dan_PR.L_Obrabotka) + " " + F_Dan[1];
                                StrokHPU += "\n";

                                n += 5;
                                StrokHPU += "N" + n + " " + G_Cod[0] + " X" + (Dan_PR.D_Det - (Dan_PR.Pripusk-5));
                                StrokHPU += "\n";
                                n += 5;
                                StrokHPU += "N" + n + " "  + " Z" + 0;
                                StrokHPU += "\n";
                                n += 5;
                                StrokHPU += "N" + n + " " + G_Cod[0] + " X" + (Dan_PR.D_Det - Dan_PR.Pripusk + i - 5);
                                StrokHPU += "\n";


                            } else {

                                n += 5;
                                StrokHPU += "N" + n + " " + G_Cod[1] + " X" + Dan_PR.D_Det;
                                StrokHPU += "\n";
                                n += 5;
                                StrokHPU += "N" + n + " "  + " " + "ANG=" + ANG + " " + " Z-" + (Dan_PR.L_Obrabotka) + " " + F_Dan[1];
                                StrokHPU += "\n";

                                n += 5;
                                StrokHPU += "N" + n + " " + G_Cod[0] + " X" + (Dan_PR.D_Det - (Dan_PR.Pripusk -5));
                                StrokHPU += "\n";
                                n += 5;
                                StrokHPU += "N" + n + " "  + " Z" + 0;
                                StrokHPU += "\n";

                            }
                        }
                    }
                        n += 5;
                        StrokHPU += "N" + n + " " + G_Cod[1] + " X" + Dan_PR.D_Det + " " + F_Dan[1];
                        StrokHPU += "\n";
                        n += 5;
                        StrokHPU += "N" + n + " "  + " " + "ANG=" + ANG + " " + " Z-" + (Dan_PR.L_Obrabotka) + " " + F_Dan[1];
                        StrokHPU += "\n";

                        n += 5;
                        StrokHPU += "N" + n + " " + G_Cod[0] + " X" + (Dan_PR.D_Det - (Dan_PR.Pripusk -5));
                        StrokHPU += "\n";
                        n += 5;
                        StrokHPU += "N" + n + " "  + " Z" + 0;
                        StrokHPU += "\n";
                        n += 5;
                        StrokHPU += "N" + n + " " + M_Cod[6];
                        StrokHPU += "\n";
                        n += 5;
                        StrokHPU += "N" + n + " " + M_Cod[7];
                        StrokHPU += "\n";

                    }


            }


        return  StrokHPU;
    }

    public String NAR_D_Obra(Model_Vhod_Dan Dan_PR , int S, int M )
    {
         StrokHPU = null;
        n = 5;


            if(Dan_PR.ANG==0) {
                StrokHPU = "N" + n;
                StrokHPU += " " + M_Cod[M];
                StrokHPU += " " + M_Cod[5];
                StrokHPU += " S" + S;
                StrokHPU += " T" + Dan_PR.T_Instrument;
                StrokHPU += " H" + Dan_PR.H_Instrument;
                StrokHPU += "\n";
                n += 5;
                StrokHPU += "N" + n + " " + G_Cod[0] + " Z" + 5;
                StrokHPU += "\n";
                n += 5;
                StrokHPU += "N" + n + " "  + " X" + (Dan_PR.D_Det + Dan_PR.Pripusk + 5);
                StrokHPU += "\n";
                n += 5;
                StrokHPU += "N" + n + " " + G_Cod[1] + " Z" + 0 + " X" + (Dan_PR.D_Det + Dan_PR.Pripusk) + " " + F_Dan[3];
                StrokHPU += "\n";

                if (Dan_PR.Pripusk > 8) {
                    for (int i = 8; Dan_PR.Pripusk > i; i += 8) {
                        if (Dan_PR.Pripusk - i > 0) {
                            n += 5;
                            StrokHPU += "N" + n + " " + G_Cod[1] + " X" + (Dan_PR.D_Det + (Dan_PR.Pripusk - i)) + " " + F_Dan[1];
                            StrokHPU += "\n";
                            n += 5;
                            StrokHPU += "N" + n + " "  + " Z-" + (Dan_PR.L_Obrabotka) + " " + F_Dan[1];
                            StrokHPU += "\n";
                            n += 5;
                            StrokHPU += "N" + n + " " + G_Cod[0] + " Z" + 0;
                            StrokHPU += "\n";

                        } else {
                            n += 5;
                            StrokHPU += "N" + n + " " + G_Cod[1] + " X" + Dan_PR.D_Det;
                            StrokHPU += "\n";
                            n += 5;
                            StrokHPU += "N" + n + " "  + " Z-" + (Dan_PR.L_Obrabotka) + " " + F_Dan[1];
                            StrokHPU += "\n";
                            n += 5;
                            StrokHPU += "N" + n + " " + G_Cod[0] + " X" + (Dan_PR.D_Det +5);
                            StrokHPU += "\n";
                            n += 5;
                            StrokHPU += "N" + n + " "  + " Z" + 0;
                            StrokHPU += "\n";

                        }
                    }
                }
                    n += 5;
                    StrokHPU += "N" + n + " " + G_Cod[1] + " X" + Dan_PR.D_Det;
                    StrokHPU += "\n";
                    n += 5;
                    StrokHPU += "N" + n + " "  + " Z-" + (Dan_PR.L_Obrabotka) + " " + F_Dan[1];
                    StrokHPU += "\n";
                    n += 5;
                    StrokHPU += "N" + n + " " + G_Cod[0] + " X" + (Dan_PR.D_Det + 5) ;
                    StrokHPU += "\n";
                    n += 5;
                    StrokHPU += "N" + n + " "  + " Z" + 0;
                    StrokHPU += "\n";
                    n += 5;
                    StrokHPU += "N" + n + " " + M_Cod[6];
                    StrokHPU += "\n";
                    n += 5;
                    StrokHPU += "N" + n + " " + M_Cod[7];
                    StrokHPU += "\n";




            }
            if(Dan_PR.ANG!=0) {

                ANG=180+Dan_PR.ANG;
                if(ANG<180) {
                    StrokHPU = "N" + n;
                    StrokHPU += " " + M_Cod[M];
                    StrokHPU += " " + M_Cod[5];
                    StrokHPU += " S" + S;
                    StrokHPU += " T" + Dan_PR.T_Instrument;
                    StrokHPU += " H" + Dan_PR.H_Instrument;
                    StrokHPU += "\n";
                    n += 5;
                    StrokHPU += "N" + n + " " + G_Cod[0] + " Z" + 5;
                    StrokHPU += "\n";
                    n += 5;
                    StrokHPU += "N" + n + " "  + " X" + (Dan_PR.D_Det + Dan_PR.Pripusk + 5);
                    StrokHPU += "\n";
                    n += 5;
                    StrokHPU += "N" + n + " " + G_Cod[1] + " Z" + 0 + " X" + (Dan_PR.D_Det + Dan_PR.Pripusk) + " " + F_Dan[3];
                    StrokHPU += "\n";

                    if (Dan_PR.Pripusk > 8) {
                        for (int i = 8; Dan_PR.Pripusk > i; i += 8) {
                            if (Dan_PR.Pripusk - i > 0) {
                                n += 5;
                                StrokHPU += "N" + n + " " + G_Cod[1] + " X" + (Dan_PR.D_Det + (Dan_PR.Pripusk - i)) + " " + F_Dan[1];
                                StrokHPU += "\n";
                                n += 5;
                                StrokHPU += "N" + n + " "  + " " + "ANG=" + ANG + " " + " Z-" + (Dan_PR.L_Obrabotka) + " " + F_Dan[1];
                                StrokHPU += "\n";

                                n += 5;
                                StrokHPU += "N" + n + " " + G_Cod[0] + " Z" + 0;
                                StrokHPU += "\n";
                                n += 5;
                                StrokHPU += "N" + n + " "  + " X" + (Dan_PR.D_Det + Dan_PR.Pripusk -i + 5);
                                StrokHPU += "\n";


                            } else {

                                n += 5;
                                StrokHPU += "N" + n + " " + G_Cod[1] + " X" + Dan_PR.D_Det;
                                StrokHPU += "\n";
                                n += 5;
                                StrokHPU += "N" + n + " "  + " " + "ANG=" + ANG + " " + " Z-" + (Dan_PR.L_Obrabotka) + " " + F_Dan[1];
                                StrokHPU += "\n";
                                n += 5;
                                StrokHPU += "N" + n + " " + G_Cod[0] + " Z" + 0;
                                StrokHPU += "\n";

                            }
                        }
                    }
                        n += 5;
                        StrokHPU += "N" + n + " " + G_Cod[1] + " X" + Dan_PR.D_Det + " " + F_Dan[1];
                        StrokHPU += "\n";
                        n += 5;
                        StrokHPU += "N" + n + " "  + " " + "ANG=" + ANG + " " + " Z-" + (Dan_PR.L_Obrabotka) + " " + F_Dan[1];
                        StrokHPU += "\n";
                        n += 5;
                        StrokHPU += "N" + n + " " + G_Cod[0] + " Z" + 0;
                        StrokHPU += "\n";
                        n += 5;
                        StrokHPU += "N" + n + " " + M_Cod[6];
                        StrokHPU += "\n";
                        n += 5;
                        StrokHPU += "N" + n + " " + M_Cod[7];
                        StrokHPU += "\n";


                }
                if(ANG>180) {
                    StrokHPU = "N" + n;
                    StrokHPU += " " + M_Cod[M];
                    StrokHPU += " " + M_Cod[5];
                    StrokHPU += " S" + S;
                    StrokHPU += " T" + Dan_PR.T_Instrument;
                    StrokHPU += " H" + Dan_PR.H_Instrument;
                    StrokHPU += "\n";
                    n += 5;
                    StrokHPU += "N" + n + " " + G_Cod[0] + " Z" + 5;
                    StrokHPU += "\n";
                    n += 5;
                    StrokHPU += "N" + n + " "  + " X" + (Dan_PR.D_Det + Dan_PR.Pripusk + 5);
                    StrokHPU += "\n";
                    n += 5;
                    StrokHPU += "N" + n + " " + G_Cod[1] + " Z" + 0 + " X" + (Dan_PR.D_Det + Dan_PR.Pripusk) + " " + F_Dan[3];
                    StrokHPU += "\n";

                    if (Dan_PR.Pripusk > 8) {
                        for (int i = 8; Dan_PR.Pripusk > i; i += 8) {
                            if (Dan_PR.Pripusk - i > 0) {
                                n += 5;
                                StrokHPU += "N" + n + " " + G_Cod[1] + " X" + (Dan_PR.D_Det + (Dan_PR.Pripusk - i)) + " " + F_Dan[1];
                                StrokHPU += "\n";
                                n += 5;
                                StrokHPU += "N" + n + " "  + " " + "ANG=" + ANG + " " + " Z-" + (Dan_PR.L_Obrabotka) + " " + F_Dan[1];
                                StrokHPU += "\n";

                                n += 5;
                                StrokHPU += "N" + n + " " + G_Cod[0] + " X" + (Dan_PR.D_Det + (Dan_PR.Pripusk+5));
                                StrokHPU += "\n";
                                n += 5;
                                StrokHPU += "N" + n + " "  + " Z" + 0;
                                StrokHPU += "\n";
                                n += 5;
                                StrokHPU += "N" + n + " "  + " X" + (Dan_PR.D_Det + Dan_PR.Pripusk - i + 5);
                                StrokHPU += "\n";


                            } else {

                                n += 5;
                                StrokHPU += "N" + n + " " + G_Cod[1] + " X" + Dan_PR.D_Det;
                                StrokHPU += "\n";
                                n += 5;
                                StrokHPU += "N" + n + " " + " " + "ANG=" + ANG + " " + " Z-" + (Dan_PR.L_Obrabotka) + " " + F_Dan[1];
                                StrokHPU += "\n";

                                n += 5;
                                StrokHPU += "N" + n + " " + G_Cod[0] + " X" + (Dan_PR.D_Det + (Dan_PR.Pripusk +5));
                                StrokHPU += "\n";
                                n += 5;
                                StrokHPU += "N" + n + " " + " Z" + 0;
                                StrokHPU += "\n";

                            }
                        }
                    }
                        n += 5;
                        StrokHPU += "N" + n + " " + G_Cod[1] + " X" + Dan_PR.D_Det + " " + F_Dan[1];
                        StrokHPU += "\n";
                        n += 5;
                        StrokHPU += "N" + n + " "  + " " + "ANG=" + ANG + " " + " Z-" + (Dan_PR.L_Obrabotka) + " " + F_Dan[1];
                        StrokHPU += "\n";

                        n += 5;
                        StrokHPU += "N" + n + " " + G_Cod[0] + " X" + (Dan_PR.D_Det + (Dan_PR.Pripusk +5)) ;
                        StrokHPU += "\n";
                        n += 5;
                        StrokHPU += "N" + n + " " + " Z" + 0;
                        StrokHPU += "\n";
                        n += 5;
                        StrokHPU += "N" + n + " " + M_Cod[6];
                        StrokHPU += "\n";
                        n += 5;
                        StrokHPU += "N" + n + " " + M_Cod[7];
                        StrokHPU += "\n";


                }

            }


        return  StrokHPU;
    }




}

