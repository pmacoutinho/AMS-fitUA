package com.example.myapplication;


import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.DataInteraction;
import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void mainActivityTest() {
        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.editEmail),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                        0),
                                7),
                        isDisplayed()));
        appCompatEditText.perform(replaceText("test"), closeSoftKeyboard());

        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.editPassword),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                        0),
                                8),
                        isDisplayed()));
        appCompatEditText2.perform(replaceText("123"), closeSoftKeyboard());

        ViewInteraction materialButton = onView(
                allOf(withId(R.id.buttonEntrar), withText("Entrar"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                        0),
                                6),
                        isDisplayed()));
        materialButton.perform(click());

        ViewInteraction appCompatImageButton = onView(
                allOf(withId(R.id.imgButton_planosTreino),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                23),
                        isDisplayed()));
        appCompatImageButton.perform(click());

        ViewInteraction recyclerView = onView(
                allOf(withId(R.id.recyclerViewPlanosTreinos),
                        childAtPosition(
                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                0)));
        recyclerView.perform(actionOnItemAtPosition(1, click()));

        ViewInteraction materialButton2 = onView(
                allOf(withId(R.id.button_treino_ginasio), withText("Adicionar treino no ginásio"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                11),
                        isDisplayed()));
        materialButton2.perform(click());

        ViewInteraction appCompatImageButton2 = onView(
                allOf(withId(R.id.imgButton_back_arrow),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                10),
                        isDisplayed()));
        appCompatImageButton2.perform(click());

        ViewInteraction recyclerView2 = onView(
                allOf(withId(R.id.recyclerViewPlanosTreinos),
                        childAtPosition(
                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                0)));
        recyclerView2.perform(actionOnItemAtPosition(3, click()));

        ViewInteraction materialButton3 = onView(
                allOf(withId(R.id.button_treino_casa), withText("Adicionar treino em casa"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                0),
                        isDisplayed()));
        materialButton3.perform(click());

        ViewInteraction materialButton4 = onView(
                allOf(withId(R.id.button_treino_ginasio), withText("Adicionar treino no ginásio"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                12),
                        isDisplayed()));
        materialButton4.perform(click());

        ViewInteraction appCompatImageButton3 = onView(
                allOf(withId(R.id.imgButton_back_arrow),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                11),
                        isDisplayed()));
        appCompatImageButton3.perform(click());

        ViewInteraction appCompatImageButton4 = onView(
                allOf(withId(R.id.imgButton_back_arrow),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                2),
                        isDisplayed()));
        appCompatImageButton4.perform(click());

        ViewInteraction appCompatImageButton5 = onView(
                allOf(withId(R.id.imgButton_treinoCasa),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                26),
                        isDisplayed()));
        appCompatImageButton5.perform(click());

        ViewInteraction recyclerView3 = onView(
                allOf(withId(R.id.recyclerViewTreinoCasa),
                        childAtPosition(
                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                0)));
        recyclerView3.perform(actionOnItemAtPosition(0, click()));

        ViewInteraction materialButton5 = onView(
                allOf(withId(R.id.button_iniciarTreino), withText("Iniciar Treino (Zoom)"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                12),
                        isDisplayed()));
        materialButton5.perform(click());

        ViewInteraction materialButton6 = onView(
                allOf(withId(R.id.button_remover_treino), withText("Remover Treino"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                11),
                        isDisplayed()));
        materialButton6.perform(click());

        ViewInteraction appCompatImageButton6 = onView(
                allOf(withId(R.id.imgButton_back_arrow),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                2),
                        isDisplayed()));
        appCompatImageButton6.perform(click());

        ViewInteraction appCompatImageButton7 = onView(
                allOf(withId(R.id.imgButton_treinoGinasio),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                21),
                        isDisplayed()));
        appCompatImageButton7.perform(click());

        ViewInteraction recyclerView4 = onView(
                allOf(withId(R.id.recyclerViewTreinoGinasio),
                        childAtPosition(
                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                0)));
        recyclerView4.perform(actionOnItemAtPosition(0, click()));

        ViewInteraction materialButton7 = onView(
                allOf(withId(R.id.button_remover_treino), withText("Remover Treino"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                11),
                        isDisplayed()));
        materialButton7.perform(click());

        ViewInteraction appCompatImageButton8 = onView(
                allOf(withId(R.id.imgButton_back_arrow),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                2),
                        isDisplayed()));
        appCompatImageButton8.perform(click());

        ViewInteraction appCompatImageButton9 = onView(
                allOf(withId(R.id.imgButton_estatisticas),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                24),
                        isDisplayed()));
        appCompatImageButton9.perform(click());

        ViewInteraction appCompatSpinner = onView(
                allOf(withId(R.id.spinner),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                5),
                        isDisplayed()));
        appCompatSpinner.perform(click());

        DataInteraction appCompatCheckedTextView = onData(anything())
                .inAdapterView(childAtPosition(
                        withClassName(is("android.widget.PopupWindow$PopupBackgroundView")),
                        0))
                .atPosition(1);
        appCompatCheckedTextView.perform(click());

        ViewInteraction appCompatEditText3 = onView(
                allOf(withId(R.id.editText_cardio_titulo),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                9),
                        isDisplayed()));
        appCompatEditText3.perform(replaceText("test - 21-21-21"), closeSoftKeyboard());

        ViewInteraction appCompatEditText4 = onView(
                allOf(withId(R.id.editText_cardio_calorias),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                3),
                        isDisplayed()));
        appCompatEditText4.perform(replaceText("300"), closeSoftKeyboard());

        ViewInteraction appCompatEditText5 = onView(
                allOf(withId(R.id.editText_cardio_tempo),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        appCompatEditText5.perform(replaceText("300"), closeSoftKeyboard());

        ViewInteraction materialButton8 = onView(
                allOf(withId(R.id.button_confirmar_cardio), withText("Confirmar"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                10),
                        isDisplayed()));
        materialButton8.perform(click());

        ViewInteraction appCompatSpinner2 = onView(
                allOf(withId(R.id.spinner),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                5),
                        isDisplayed()));
        appCompatSpinner2.perform(click());

        DataInteraction appCompatCheckedTextView2 = onData(anything())
                .inAdapterView(childAtPosition(
                        withClassName(is("android.widget.PopupWindow$PopupBackgroundView")),
                        0))
                .atPosition(2);
        appCompatCheckedTextView2.perform(click());

        ViewInteraction appCompatEditText6 = onView(
                allOf(withId(R.id.editText_pesos_titulo),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                9),
                        isDisplayed()));
        appCompatEditText6.perform(replaceText("test - 12-12-12"), closeSoftKeyboard());

        ViewInteraction appCompatEditText7 = onView(
                allOf(withId(R.id.editText_pesos_peso),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                3),
                        isDisplayed()));
        appCompatEditText7.perform(replaceText("100"), closeSoftKeyboard());

        ViewInteraction appCompatEditText8 = onView(
                allOf(withId(R.id.editText_pesos_tempo),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                0),
                        isDisplayed()));
        appCompatEditText8.perform(replaceText("100"), closeSoftKeyboard());

        ViewInteraction materialButton9 = onView(
                allOf(withId(R.id.button_confirmar_pesos), withText("Confirmar"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                10),
                        isDisplayed()));
        materialButton9.perform(click());

        ViewInteraction materialButton10 = onView(
                allOf(withId(R.id.button_abrir_estatisticas), withText("Abrir"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                6),
                        isDisplayed()));
        materialButton10.perform(click());

        ViewInteraction recyclerView5 = onView(
                allOf(withId(R.id.recyclerViewEstatisticas),
                        childAtPosition(
                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                0)));
        recyclerView5.perform(actionOnItemAtPosition(0, click()));

        ViewInteraction materialButton11 = onView(
                allOf(withId(R.id.button_eliminar), withText("Eliminar"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                8),
                        isDisplayed()));
        materialButton11.perform(click());

        ViewInteraction recyclerView6 = onView(
                allOf(withId(R.id.recyclerViewEstatisticas),
                        childAtPosition(
                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                0)));
        recyclerView6.perform(actionOnItemAtPosition(0, click()));

        ViewInteraction materialButton12 = onView(
                allOf(withId(R.id.button_eliminar), withText("Eliminar"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                8),
                        isDisplayed()));
        materialButton12.perform(click());

        ViewInteraction appCompatImageButton10 = onView(
                allOf(withId(R.id.imgButton_back_arrow),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                2),
                        isDisplayed()));
        appCompatImageButton10.perform(click());

        ViewInteraction appCompatImageButton11 = onView(
                allOf(withId(R.id.imgButton_back_arrow),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                4),
                        isDisplayed()));
        appCompatImageButton11.perform(click());

        ViewInteraction appCompatImageButton12 = onView(
                allOf(withId(R.id.imgButton_contactos),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                29),
                        isDisplayed()));
        appCompatImageButton12.perform(click());

        ViewInteraction appCompatImageButton13 = onView(
                allOf(withId(R.id.imgButton_back_arrow),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                10),
                        isDisplayed()));
        appCompatImageButton13.perform(click());

        ViewInteraction appCompatImageButton14 = onView(
                allOf(withId(R.id.imgButton_nutricao),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                27),
                        isDisplayed()));
        appCompatImageButton14.perform(click());

        ViewInteraction materialButton13 = onView(
                allOf(withId(R.id.button_confirmar), withText("Confirmar"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                5),
                        isDisplayed()));
        materialButton13.perform(click());

        ViewInteraction materialButton14 = onView(
                allOf(withId(R.id.button_confirmar), withText("Confirmar"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                5),
                        isDisplayed()));
        materialButton14.perform(click());

        ViewInteraction materialRadioButton = onView(
                allOf(withId(R.id.radioButton5), withText("11h-11h30"),
                        childAtPosition(
                                allOf(withId(R.id.radioGroup_nutricao),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                4)),
                                4),
                        isDisplayed()));
        materialRadioButton.perform(click());

        ViewInteraction materialButton15 = onView(
                allOf(withId(R.id.button_confirmar), withText("Confirmar"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                3),
                        isDisplayed()));
        materialButton15.perform(click());

        ViewInteraction materialButton16 = onView(
                allOf(withId(android.R.id.button1), withText("Sim"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                3)));
        materialButton16.perform(scrollTo(), click());

        ViewInteraction appCompatImageButton15 = onView(
                allOf(withId(R.id.imgButton_saude),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                28),
                        isDisplayed()));
        appCompatImageButton15.perform(click());

        ViewInteraction materialButton17 = onView(
                allOf(withId(R.id.button_abrir), withText("Abrir"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                6),
                        isDisplayed()));
        materialButton17.perform(click());

        ViewInteraction appCompatImageButton16 = onView(
                allOf(withId(R.id.imgButton_back_arrow),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                3),
                        isDisplayed()));
        appCompatImageButton16.perform(click());

        ViewInteraction appCompatImageButton17 = onView(
                allOf(withId(R.id.imgButton_produtos),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                25),
                        isDisplayed()));
        appCompatImageButton17.perform(click());

        ViewInteraction appCompatImageButton18 = onView(
                allOf(withId(R.id.imgButton_prozis),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                12),
                        isDisplayed()));
        appCompatImageButton18.perform(click());

        ViewInteraction appCompatImageButton19 = onView(
                allOf(withId(R.id.imgButton_my_protein),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        appCompatImageButton19.perform(click());

        ViewInteraction appCompatImageButton20 = onView(
                allOf(withId(R.id.imgButton_back_arrow),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                11),
                        isDisplayed()));
        appCompatImageButton20.perform(click());

        ViewInteraction appCompatImageButton21 = onView(
                allOf(withId(R.id.imgButton_falarPT),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                22),
                        isDisplayed()));
        appCompatImageButton21.perform(click());

        ViewInteraction materialButton18 = onView(
                allOf(withId(R.id.button_logOut), withText("Log Out"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                0),
                        isDisplayed()));
        materialButton18.perform(click());

        ViewInteraction appCompatEditText9 = onView(
                allOf(withId(R.id.editEmail),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                        0),
                                7),
                        isDisplayed()));
        appCompatEditText9.perform(replaceText("pt"), closeSoftKeyboard());

        ViewInteraction appCompatEditText10 = onView(
                allOf(withId(R.id.editPassword),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                        0),
                                8),
                        isDisplayed()));
        appCompatEditText10.perform(replaceText("123"), closeSoftKeyboard());

        ViewInteraction materialButton19 = onView(
                allOf(withId(R.id.buttonEntrar), withText("Entrar"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                        0),
                                6),
                        isDisplayed()));
        materialButton19.perform(click());

        ViewInteraction appCompatImageButton22 = onView(
                allOf(withId(R.id.imgButton_planosTreinoPT),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                12),
                        isDisplayed()));
        appCompatImageButton22.perform(click());

        ViewInteraction recyclerView7 = onView(
                allOf(withId(R.id.recyclerViewPlanosTreinos),
                        childAtPosition(
                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                0)));
        recyclerView7.perform(actionOnItemAtPosition(1, click()));

        ViewInteraction appCompatImageButton23 = onView(
                allOf(withId(R.id.imgButton_back_arrow),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                10),
                        isDisplayed()));
        appCompatImageButton23.perform(click());

        ViewInteraction appCompatImageButton24 = onView(
                allOf(withId(R.id.imgButton_back_arrow),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                2),
                        isDisplayed()));
        appCompatImageButton24.perform(click());

        ViewInteraction materialButton20 = onView(
                allOf(withId(R.id.button_logOut), withText("Log Out"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                0),
                        isDisplayed()));
        materialButton20.perform(click());

        ViewInteraction materialButton21 = onView(
                allOf(withId(R.id.buttonFacebook), withText("Entrar com o Facebook"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                        0),
                                3),
                        isDisplayed()));
        materialButton21.perform(click());

        ViewInteraction materialButton22 = onView(
                allOf(withId(R.id.buttonTwitter), withText("Entrar com o Twitter"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                        0),
                                2),
                        isDisplayed()));
        materialButton22.perform(click());

        ViewInteraction materialButton23 = onView(
                allOf(withId(R.id.buttonGoogle), withText("Entrar com a Google"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                        0),
                                1),
                        isDisplayed()));
        materialButton23.perform(click());
    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
