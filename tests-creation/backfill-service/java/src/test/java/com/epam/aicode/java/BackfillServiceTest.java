package com.epam.aicode.java;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class BackfillServiceTest {
    @Mock
    private SrcSystem srcSystem;

    @Mock
    private DstSystem dstSystem;

    @InjectMocks
    private BackfillService backfillService;

    @Test
    void testBackfill_NewAccount() {

    }

    @Test
    void testBackfill_ExistingAccount() {

    }

    @Test
    void testBackfill_NotNeeded() {

    }

    @Test
    void testBackfill_MultipleTransfers() {

    }
}
