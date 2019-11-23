package com.github.jrsofty.game.api.gds;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;

public class GameDataEntryObject<T extends Serializable> implements GameDataEntry<T> {

    /**
     *
     */
    private static final long serialVersionUID = 2912789800268321382L;
    private String entryName;
    private T entryData;

    @Override
    public String getEntryName() {

        return this.entryName;
    }

    @Override
    public void setEntryName(final String entryName) {
        this.entryName = entryName;
    }

    @Override
    public T getEntryData() {
        return this.entryData;
    }

    @Override
    public void setEntryData(final T entryData) {
        this.entryData = entryData;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append('{');
        if (this.entryData instanceof Collection<?>) {
            final Collection<?> collection = (Collection<?>) this.entryData;
            final Iterator<?> itr = collection.iterator();
            builder.append(this.getEntryName()).append(":[");
            while (itr.hasNext()) {
                final Object o = itr.next();
                if (o instanceof GameDataEntry) {
                    builder.append(((GameDataEntry<?>) o).toString());
                } else {
                    builder.append(String.valueOf(o));
                }
                if (itr.hasNext()) {
                    builder.append(',');
                }
            }
            builder.append(']');
        } else {
            builder.append(this.entryName).append(':').append(String.valueOf(this.entryData));
        }
        builder.append('}');
        return builder.toString();
    }

    @Override
    public String toString(final boolean pretty) {
        final StringBuilder builder = new StringBuilder();
        builder.append('{');
        if (this.entryData instanceof Collection<?>) {
            final Collection<?> collection = (Collection<?>) this.entryData;
            final Iterator<?> itr = collection.iterator();
            builder.append(this.getEntryName()).append(":[");
            while (itr.hasNext()) {
                final Object o = itr.next();
                if (o instanceof GameDataEntry) {
                    builder.append(((GameDataEntry<?>) o).toString(pretty));
                } else {
                    builder.append(String.valueOf(o));
                }
                if (itr.hasNext()) {
                    builder.append(',');
                }
            }
            builder.append(']');
        } else {
            builder.append(this.entryName).append(':').append(String.valueOf(this.entryData));
        }
        builder.append('}').append(System.lineSeparator());
        return builder.toString();
    }

}
