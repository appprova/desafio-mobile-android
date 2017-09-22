package net.hugonardo.gjp.tools.dummy;

import net.hugonardo.gjp.api.repo.Repo;
import net.hugonardo.gjp.api.user.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyRepositories {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<Repo> ITEMS = new ArrayList<>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<Long, Repo> ITEM_MAP = new HashMap<>();

    private static final int COUNT = 200;
    private static final int PER_PAGE = 10;
    private static final int PAGES = COUNT / PER_PAGE;

    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createRepo(i));
        }
    }

    public static List<Repo> getPage(int page) {
        if (page > PAGES) {
            throw new IndexOutOfBoundsException();
        }

        int first = (page - 1) * PER_PAGE;
        int last = first + PER_PAGE;
        return ITEMS.subList(first, last);
    }

    public static Integer getNextPageToken(Integer currentPage) {
        return currentPage < PAGES ? (currentPage + 1) : null;
    }

    private static void addItem(Repo item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id(), item);
    }

    private static Repo createRepo(int position) {
        Long positionLong = (long) position;
        return Repo.builder()
                .id(positionLong)
                .name("Repositório " + position)
                .description(makeDetails(position))
                .forksCount(positionLong)
                .starsCount(positionLong)
                .owner(User.builder().id(positionLong).login("user" + position).name("User Name " + position).build())
                .build();
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }
}
