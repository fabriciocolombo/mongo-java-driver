/*
 * Copyright (c) 2008 - 2013 10gen, Inc. <http://10gen.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.mongodb.operation;

import org.mongodb.Document;
import org.mongodb.ReadPreference;

public class MongoFind extends MongoQuery {
    private Document filter;
    private Document fields;
    private Document sortCriteria;
    private boolean snapshotMode;

    public MongoFind() {
        this.filter = new Document();
    }

    public MongoFind(final Document filter) {
        this.filter = filter;
    }

    public MongoFind(final MongoFind from) {
        super(from);
        filter = from.filter;
        fields = from.fields;
        sortCriteria = from.sortCriteria;
        snapshotMode = from.snapshotMode;
    }

    public Document getFilter() {
        return filter;
    }

    public Document getOrder() {
        return sortCriteria;
    }

    public boolean isSnapshotMode() {
        return snapshotMode;
    }

    //CHECKSTYLE:OFF
    //I think we're going to have to turn off "hides a field" unless we can work out how to ignore it for builders
    public MongoFind where(final Document filter) {
        this.filter = filter;
        return this;
    }

    public MongoFind filter(final Document filter) {
        this.filter = filter;
        return this;
    }

    public MongoFind select(final Document fields) {
        this.fields = fields;
        return this;
    }

    public MongoFind order(final Document sortCriteria) {
        this.sortCriteria = sortCriteria;
        return this;
    }
    //CHECKSTYLE:ON

    @Override
    public MongoFind limit(final int limit) {
        super.limit(limit);
        return this;
    }

    @Override
    public MongoFind batchSize(final int batchSize) {
        super.batchSize(batchSize);
        return this;
    }

    @Override
    public MongoFind flags(final int flags) {
        super.flags(flags);
        return this;
    }

    public MongoFind hintIndex(final String indexName) {
        throw new UnsupportedOperationException();      // TODO
    }

    public MongoFind snapshot() {
        this.snapshotMode = true;
        return this;
    }

    public MongoFind disableTimeout() {
        throw new UnsupportedOperationException();
    }

    public MongoFind enableTimeout() {
        throw new UnsupportedOperationException();
    }

    public Document getFields() {
        return fields;
    }

    public MongoFind readPreference(final ReadPreference readPreference) {
        super.readPreference(readPreference);
        return this;
    }

    public MongoFind readPreferenceIfAbsent(final ReadPreference readPreference) {
        super.readPreferenceIfAbsent(readPreference);
        return this;
    }

    @Override
    public MongoFind skip(final int skip) {
        super.skip(skip);
        return this;
    }
}
