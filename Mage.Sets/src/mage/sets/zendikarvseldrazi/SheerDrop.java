/*
 *  Copyright 2010 BetaSteward_at_googlemail.com. All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without modification, are
 *  permitted provided that the following conditions are met:
 *
 *     1. Redistributions of source code must retain the above copyright notice, this list of
 *        conditions and the following disclaimer.
 *
 *     2. Redistributions in binary form must reproduce the above copyright notice, this list
 *        of conditions and the following disclaimer in the documentation and/or other materials
 *        provided with the distribution.
 *
 *  THIS SOFTWARE IS PROVIDED BY BetaSteward_at_googlemail.com ``AS IS'' AND ANY EXPRESS OR IMPLIED
 *  WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 *  FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL BetaSteward_at_googlemail.com OR
 *  CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 *  CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 *  SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 *  ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 *  NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
 *  ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 *  The views and conclusions contained in the software and documentation are those of the
 *  authors and should not be interpreted as representing official policies, either expressed
 *  or implied, of BetaSteward_at_googlemail.com.
 */
package mage.sets.zendikarvseldrazi;

import java.util.UUID;
import mage.abilities.effects.common.DestroyTargetEffect;
import mage.abilities.keyword.AwakenAbility;
import mage.cards.CardImpl;
import mage.constants.CardType;
import mage.constants.Rarity;
import mage.filter.common.FilterCreaturePermanent;
import mage.filter.predicate.permanent.TappedPredicate;
import mage.target.common.TargetCreaturePermanent;

/**
 *
 * @author fireshoes
 */
public class SheerDrop extends CardImpl {
    
    private final static FilterCreaturePermanent filter = new FilterCreaturePermanent("tapped creature");
    
    static {
        filter.add(new TappedPredicate());
    }

    public SheerDrop(UUID ownerId) {
        super(ownerId, 9, "Sheer Drop", Rarity.COMMON, new CardType[]{CardType.SORCERY}, "{2}{W}");
        this.expansionSetCode = "DDP";

        // Destroy target tapped creature.
        this.getSpellAbility().addEffect(new DestroyTargetEffect());
        this.getSpellAbility().addTarget(new TargetCreaturePermanent(filter));
        
        // Awaken 3-{5}{W} <i>(If you cast this spell for {5}{W}, also put three +1/+1 counters on target land you control and it becomes a 0/0 Elemental creature with haste. It's still a land.)<i>
        this.addAbility(new AwakenAbility(this, 3, "{5}{W}"));
    }

    public SheerDrop(final SheerDrop card) {
        super(card);
    }

    @Override
    public SheerDrop copy() {
        return new SheerDrop(this);
    }
}
