//package ru.iteco.fmhandroid.utils;
//
//public class CustomViewMatcherHelper {
//
//    public static void waitForElement(Matcher<View> matcher, int millis) {
//        onView(isRoot()).perform(waitForElementViewAction(matcher, millis));
//    }
//
//    public static ViewAction waitForElementViewAction(final Matcher<View> matcher, final long millis) {
//        return new ViewAction() {
//            @Override
//            public Matcher<View> getConstraints() {
//                return isRoot();
//            }
//
//            @Override
//            public String getDescription() {
//                return "wait for a specific view with attribute <" + matcher + "> during " + millis + " millis.";
//            }
//
//            @Override
//            public void perform(final UiController uiController, final View view) {
//                uiController.loopMainThreadUntilIdle();
//                final long startTime = System.currentTimeMillis();
//                final long endTime = startTime + millis;
//
//                do {
//                    for (View child : TreeIterables.breadthFirstViewTraversal(view)) {
//                        try {
//                            if (matcher.matches(child)) {
//                                return;
//                            }
//                        } catch (NoMatchingViewException e) {
//                        }
//
//                        uiController.loopMainThreadForAtLeast(100);
//                    }
//
//                }
//                while (System.currentTimeMillis() < endTime);
//
//                throw new PerformException.Builder()
//                        .withActionDescription(this.getDescription())
//                        .withViewDescription(HumanReadables.describe(view))
//                        .withCause(new TimeoutException())
//                        .build();
//            }
//        };
//    }
//    public static ViewAssertion isRecyclerView() {
//        return new ViewAssertion() {
//            @Override
//            public void check(View view, NoMatchingViewException noViewFoundException) {
//                if (!(view instanceof RecyclerView))
//                    try {
//                        throw new IllegalAccessException("Это не RecyclerView");
//                    } catch (IllegalAccessException e) {
//                        throw new RuntimeException(e);
//                    }
////                try {
////                    RecyclerView recyclerView = (RecyclerView) view;
////                }
////                catch (ClassCastException cce) {
////                    throw new IllegalStateException(“This is not a RecyclerView”);
////                }
//            }
//        };
//    }
//public static Matcher<View> recyclerViewSizeMatcher(final int matcherSize) {
//        return new BoundedMatcher<>(RecyclerView.class) {
//            @Override
//            public void describeTo(Description description) { // Доп. описание ошибки
//                description.appendText(“Item count: ”+matcherSize)
//            }
//
//            @Override
//            protected boolean matchesSafety(RecyclerView recyclerView) { // Проверка
//                return matcherSize == recyclerView.getAdapter().getItemCount();
//            }
//        };
//    }public static Matcher<View> childAtPosition(Matcher<View> matcher, final Matcher<View> parentMatcher, final int position) {
//
//        return new TypeSafeMatcher<View>() {
//            @Override
//            public void describeTo(Description description) {
//                description.appendText("Child at position " + position + " in parent ");
//                parentMatcher.describeTo(description);
//            }
//
//            @Override
//            public boolean matchesSafely(View view) {
//                ViewParent parent = view.getParent();
//                return parent instanceof ViewGroup && parentMatcher.matches((View) parent)
//                        && view.equals(((ViewGroup) parent).getChildAt(position));
//            }
//        };
//    }
//
//    public static Matcher<View> withIndex(final Matcher<View> matcher, final int index) {
//        return new TypeSafeMatcher<View>() {
//            int currentIndex = 0;
//
//            @Override
//            public void describeTo(Description description) {
//                description.appendText("with index: ");
//                description.appendValue(index);
//                matcher.describeTo(description);
//            }
//
//            @Override
//            public boolean matchesSafely(View view) {
//                return matcher.matches(view) && currentIndex++ == index;
//            }
//        };
//    }
//}
